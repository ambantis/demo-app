package controllers

import views._

import play.api.mvc.{Action, Controller}

object Application extends Controller {

  def index = Action {
    Ok(html.index())
  }

}
