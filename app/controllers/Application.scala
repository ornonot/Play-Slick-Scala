package controllers

import play.api._
import play.api.mvc._
 
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  private def greeting(say: String)(implicit req: RequestHeader) =
    say + "," + req.remoteAddress

  def say = Action {implicit request =>
    Ok(greeting("Hello!"))}

  def something = TODO

  def redirect1 = Action{
    Redirect(routes.SampleController.sample1)}
  def redirect2 = Action{
    Redirect("http://www.atmarkit.co.jp/")}

  def add(rhs: Int,lhs: Int) = Action{
    Ok(views.html.index("add :" + (rhs + lhs)))
  }

  def path(path: String) = Action{
    Ok(views.html.index(path))
  }

  def sample5(fixedValue:String) = Action{
    println("fixedValue:" + fixedValue)
    Ok(views.html.index("fixedValue:" + fixedValue))
  }

  def sample6(defaultValue:Int) = Action{
    
    println("defaultValue:" + defaultValue)

    Ok(views.html.index("defaultValue:" + defaultValue))
  }

  def sample7(optValue:Option[String]) = Action{
    println("optValue:" + optValue)
    val res = optValue match{
      case Some(opt) => opt
      case None => "nothing"
    }
    Ok(views.html.index("optValue:" + res))
  }
//  def hello(name:String) = Action {
//    Ok("hello, " + name +"!")
//  }

//  val form: Form[String] = Form("example" -> text)

//  def test = Action {
//    Ok(views.html.test())
//  }

//  def show = Action { req =>
//    val result: String = form.bindFromRequest()(req).get
//    Ok("入力値:" + result)
//  }
}
