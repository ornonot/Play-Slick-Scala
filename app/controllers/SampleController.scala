package controllers
import play.api._
import play.api.mvc._
object SampleController extends Controller{

  def sample1 = Action {
      Ok(views.html.index("Sample Controller#sample1"))
  }
  def sample2 = Action {
      Ok(views.html.index("Sample Controller#Sample2"))
  }
}
