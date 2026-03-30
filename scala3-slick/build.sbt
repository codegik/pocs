val scala3Version = "3.6.4"

ThisBuild / organization := "codegik"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scala3Version

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-slick",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick"           % "3.5.2",
      "com.typesafe.slick" %% "slick-hikaricp"  % "3.5.2",
      "com.h2database"      % "h2"              % "2.3.232",
      "org.slf4j"           % "slf4j-nop"       % "2.0.13",
      "org.scalameta"      %% "munit"            % "1.0.0" % Test,
    )
  )
