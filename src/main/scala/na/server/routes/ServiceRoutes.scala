package na.server.routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.headers._
import na.server.response.Person

trait ServiceRoutes {
  implicit def system: ActorSystem

  lazy val topRoutes: Route = {
    path("api-test") {
      get {
        println("http-request on /api-test")
        respondWithHeaders(`Access-Control-Allow-Origin`.*, `Access-Control-Allow-Headers`("X-Requested-With")) {
          complete(Seq(Person("Pawel", 25), Person("Joy", 31), Person("DeadPool", 40)))
        }
      }
    }
  }
}