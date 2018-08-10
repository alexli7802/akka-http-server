package na.server.routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

trait ServiceRoutes {
  implicit def system: ActorSystem

  lazy val topRoutes: Route = {
    path("api-test") {
      get {
        complete("received request on api-test!")
      }
    }
  }
}