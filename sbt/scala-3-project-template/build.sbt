import java.util.Calendar

val scala3Version = "3.6.4"
val sampleStringTask = taskKey[String]("A sample string task.")
val sampleIntTask = taskKey[Int]("A sample int task.")

ThisBuild / organization  := "codegik"
ThisBuild / version       := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion  := scala3Version

lazy val root = project
  .in(file("."))
  .settings(

    sampleStringTask := {
      println(s"Running sample string task -> ${Calendar.getInstance().getTime}")
      System.getProperty("user.home")
    },
    
    sampleIntTask := {
      val sum = 1 + 2
      println(s"Running sample int task: $sum -> ${Calendar.getInstance().getTime}")
      sum
    },

    scalacOptions := {
      val s = sampleStringTask.value  // update task happens-before scalacOptions
      val i = sampleIntTask.value     // clean task happens-before scalacOptions
      Seq(s, i.toString)
    },

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,
    libraryDependencies += "io.circe" %% "circe-core" % "0.14.3",
    libraryDependencies += "io.circe" %% "circe-generic" % "0.14.3",
    libraryDependencies += "io.circe" %% "circe-parser" % "0.14.3",
    Test / parallelExecution := true
  )
