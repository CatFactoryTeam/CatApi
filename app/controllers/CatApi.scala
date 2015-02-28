package controllers

import services.CatShelter

import models.Cat

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object CatApi extends Controller {

  implicit val catWrites = new Writes[Cat] {
    def writes(cat: Cat) = Json.obj("id" -> cat.id, "link" -> cat.link)
  }

  def list = Action {
    Ok(Json.obj(
      "status" -> "success",
      "data" -> CatShelter.cats
    ))
  }
}
