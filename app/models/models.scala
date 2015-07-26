package models
import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.MySQLDriver.api._
/** User Model */
case class User(id: Int,name:String,email:String,password:String)

class UserTable(tag: Tag) extends Table[User](tag, "USER"){
    def id = column[Int]("id", O.PrimaryKey)
    def name = column[String]("name", O.NotNull)
    def email = column[String]("email")
    def password = column[String]("password")
    def * = (id,name,email,password)<>(User.tupled,User.unapply _)
}
/*
object UserTable extends DAO{
  val db = Database.forConfig("MySQL")
  val users = TableQuery[UserTable]
    def user(id:Int,name:String,email:String,password:String) 
    :User = User(id,name,email,password)
  val insert = DBIO.seq(
    users += user
  )
  val updateQuery = for { u <- users if u.id == 4 } yield u.name
  val update = updateQuery.update("tono")
}*/
