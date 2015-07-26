/*package models

import scala.concurrent.ExecutionContext.Implicits.global

import scala.slick.driver.MySQL
class DAO(override val Profile : JdbcProfile) 
    extends UserCompoment with Profile{
  val Users = TableQuery[UsersTable]
}

object current{
  val dao = DatabaseConfigProvider.get[JdbcProfile](Play.current)
}
*/

