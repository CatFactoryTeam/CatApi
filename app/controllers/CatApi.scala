package controllers

import models.Cat
import models.Cats

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object CatApi extends Controller {

  implicit val catWrites: Writes[Cat] = (
    (JsPath \ "id").write[String] and
    (JsPath \ "link").write[String]
  )(unlift(Cat.unapply))

  def list = Action {
    Ok(Json.obj(
      "status" -> "success",
      "data" -> Cats.list
    ))
  }
}
