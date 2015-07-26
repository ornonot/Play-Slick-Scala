 /*package controllers
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object UserController extends Controller{
  /** Form Definition */
  val userForm = Form(
    mapping("name" -> nonEmptyText,"email" -> email, "age" -> text)(User.apply)(User.unapply))

  /** Initial Display Function */
  def entryInit = Action {
    val filledForm = userForm.fill(User("user name","email address","0"))
    Ok(views.html.user.entry(filledForm))
  }
  /** User Registration Function */
  def entrySubmit = Action { implicit request =>
    userForm.bindFromRequest.fold(
      errors => {
        println("error!")
        BadRequest(views.html.user.entry(errors))
      },
      success => {
        println("entry success!")
        Ok(views.html.user.entrySubmit())
      })}}
*/
