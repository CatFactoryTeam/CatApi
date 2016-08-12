package controllers

import services.CatShelter

import models.Cat

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object CatApi extends Controller {
  implicit val catToJson = new Writes[Cat] {
    def writes(cat: Cat) = Json.obj(
      "id" -> cat.id, "link" -> cat.link, "mp4" -> cat.mp4
    )
  }

  /** Retieve all cats! */
  def list = WithCors("GET") { Action {
    Ok(Json.obj(
      "status" -> "success",
      "data" -> CatShelter.cats
    ))
  }}
}
