package na.server.response

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

case class Person(name: String, age: Int)

object Person extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val personformat = jsonFormat2(Person.apply)
}

