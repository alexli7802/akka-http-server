package na.server

import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http

object WebApp extends routes.ServiceRoutes {

  implicit val system = ActorSystem("na-web-actor-system")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  lazy val log = Logging(system, "WebApp")

  def main(args: Array[String]): Unit = {
    log.info("================= WebApp starts ================")
    val bindingFuture = Http().bindAndHandle(topRoutes, "0", 8282)

    println("""
      Server online at http://localhost:8282
      Press RETURN to stop ...
      """)

    scala.io.StdIn.readLine()
    bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())

  }
}