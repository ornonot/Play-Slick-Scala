package controllers


import play.api.mvc._
import play.api.db.slick._
import models._
import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.MySQLDriver.api._
import scala.concurrent._
object SlickController extends Controller{
  val db = Database.forConfig("MySQL")
  val users = TableQuery[UserTable]
  def insert = Action.async{ implicit request =>
    val user = User(4,"toro","toro@hoge.com","poyoko")
    val insert = DBIO.seq(users += user)
    val future = db.run(insert)
    future map {s => Ok(views.html.index("insert"))}
  }

  val updateQuery = for { u <- users if u.id === 4} yield u.name
  def update = Action.async { implicit request =>
    val updateAction = updateQuery.update("tono")
    val future = db.run(updateAction)
    future map {u => Ok(views.html.index("update"))}
  }

  val deleteQuery = users.filter(_.id === 4)
  def delete = Action.async { implicit request =>
    val deleteAction = deleteQuery.delete
    val future = db.run(deleteAction)
    future map {d => Ok(views.html.index("delete"))}
  }

  val selectQuery = users.map(_.name)
  def select = Action.async { implicit request =>
    val selectAction = selectQuery.result
    val result = db.run(selectAction)
    result map {result => Ok(views.html.index(result.mkString("\n")))}
  }
}
