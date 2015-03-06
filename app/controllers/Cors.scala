package controllers

import play.api.mvc._
import scala.concurrent._
import play.api.http.HeaderNames._

/**
  * Action decorator that provide CORS support
  *
  * @author Giovanni Costagliola, Nick McCready
  */
case class WithCors(httpVerbs: String*) (action: EssentialAction) extends EssentialAction with Results {
  def apply(request: RequestHeader) = {
    implicit val executionContext: ExecutionContext = play.api.libs.concurrent.Execution.defaultContext
    val origin = request.headers.get(ORIGIN).getOrElse("*")

    if (request.method == "OPTIONS") { // preflight
      val corsAction = Action {
        request =>
        Ok("").withHeaders(
          ACCESS_CONTROL_ALLOW_ORIGIN -> origin,
          ACCESS_CONTROL_ALLOW_METHODS -> (httpVerbs.toSet + "OPTIONS").mkString(", "),
          ACCESS_CONTROL_MAX_AGE -> "3600",
          ACCESS_CONTROL_ALLOW_HEADERS ->  s"$ORIGIN, X-Requested-With, $CONTENT_TYPE, $ACCEPT, $AUTHORIZATION, X-Auth-Token",
          ACCESS_CONTROL_ALLOW_CREDENTIALS -> "true"
        )
      }
      corsAction(request)

    } else { // actual request
      action(request).map(res => res.withHeaders(
        ACCESS_CONTROL_ALLOW_ORIGIN -> origin,
        ACCESS_CONTROL_ALLOW_CREDENTIALS -> "true"
      ))
    }
  }
}
