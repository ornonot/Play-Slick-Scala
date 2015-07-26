package controllers
import play.api.mvc.Result
import play.api._
import play.api.libs.iteratee.Enumerator
import play.api.mvc._

object SessionController extends Controller{
  def setSession = Action{implicit request =>
    Ok("save session.").withSession(
      request.session + ("date" -> new java.util.Date().toString()))
  }

  def getSession = Action{implicit request =>
    request.session.get("date").map{date =>
      Ok("save session page access time:" + date)
    }.getOrElse{
      Ok("you have never access in save session page.")
    }
  }

  def removeSession = Action{
    Ok("remove session.").withNewSession
  }

  def getFlash = Action{
    implicit request =>
      Ok{
        request.flash.get("msg").getOrElse("no msg!")
      }
  }

  def setFlash = Action{
    Redirect("/readFlash").flashing(
      "msg" -> "save Flash!")
  }

}




