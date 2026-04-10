val scala3Version = "3.6.4"
val catsVersion   = "2.12.0"
val catsEffectVersion = "3.5.7"

ThisBuild / organization := "codegik"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scala3Version

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-cats",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"   % catsVersion,
      "org.typelevel" %% "cats-effect" % catsEffectVersion,
      "org.scalameta" %% "munit"       % "1.0.0"          % Test,
      "org.typelevel" %% "munit-cats-effect" % "2.0.0"    % Test,
    )
  )
