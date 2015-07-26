name := """HelloWorld"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  cache,
  evolutions,
  "com.typesafe.play" %% "anorm" % "2.4.0",
  ws,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.play" %% "play-slick" %"1.0.0",
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.0.0",
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.11" % "1.0.1"
// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//routesGenerator := InjectedRoutesGenerator
