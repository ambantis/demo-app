import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "forms"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    "com.etaty.rediscala" %% "rediscala" % "1.2",
    "org.scalatest" %% "scalatest" % "2.0" % "test"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers += "rediscala" at "https://github.com/etaty/rediscala-mvn/raw/master/releases/",
      scalacOptions ++= Seq(
        "-unchecked",
        "-deprecation",
        "-encoding", "UTF-8",
        "-feature",
        "-language:postfixOps"),
      parallelExecution in Test := false
  )

}
