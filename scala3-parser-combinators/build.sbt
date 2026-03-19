ThisBuild / organization := "codegik"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.6.4"

lazy val root = (project in file("."))
  .settings(
    name := "scala3-parser-combinators",
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
