import _root_.sbt.Keys._

name := "skinny-orm-postgresql"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies ++= {
  val scalikeVersion = "2.3.+"
  val skinnyVersion = "2.0.0.RC4"
  Seq(
    "com.typesafe" % "config" % "1.3.0",
    "joda-time" % "joda-time" % "2.9.+",

    "org.postgresql" % "postgresql" % "9.4-1205-jdbc42",
    "org.scalikejdbc" %% "scalikejdbc" % scalikeVersion,
    "org.scalikejdbc" %% "scalikejdbc-config" % scalikeVersion,
    "org.scalikejdbc" %% "scalikejdbc-test" % scalikeVersion % "test",
    "org.skinny-framework" %% "skinny-orm" % skinnyVersion,
    "org.skinny-framework" %% "skinny-test" % skinnyVersion % "test",
    "com.h2database" % "h2" % "1.4.+",

    "org.scalatest" %% "scalatest" % "2.2.4" % "test",

    "org.slf4j" % "slf4j-simple" % "1.7.13",
    "ch.qos.logback" % "logback-classic" % "1.1.3"

  )
}
