import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "sample-play-jbehave-spring-client"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    //javaJdbc,
    //javaEbean ,

    "org.jbehave" % "jbehave-spring" % "3.7",

    "org.springframework"    %    "spring-context"    %    "3.1.3.RELEASE",
    "org.springframework"    %    "spring-core"       %    "3.1.3.RELEASE",
    "org.springframework"    %    "spring-beans"      %    "3.1.3.RELEASE"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
  )

}
