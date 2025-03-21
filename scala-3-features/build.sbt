
val scala3Version = "3.6.4"

ThisBuild / organization  := "codegik"
ThisBuild / version       := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion  := scala3Version

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,
    Test / parallelExecution := true
  )
