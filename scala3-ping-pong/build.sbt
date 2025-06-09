
ThisBuild / scalaVersion := "3.3.4"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.codegik"

lazy val root = (project in file("core"))
  .settings(
    Compile / mainClass := Some("com.codegik.pingpong.Application")
  )