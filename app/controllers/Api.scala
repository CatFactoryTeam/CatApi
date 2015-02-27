package controllers

import play.api._
import play.api.mvc._

object Api extends Controller {

  def index = Action {
    Ok("A cat factory's RESTful API")
  }
}
