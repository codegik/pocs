val scala3Version       = "3.6.4"
val http4sVersion       = "0.23.30"
val circeVersion        = "0.14.10"
val fs2Version          = "3.11.0"
val catsEffectVersion   = "3.5.7"
val munitCatsEffectVer  = "2.0.0"

ThisBuild / organization := "codegik"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scala3Version

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-http4s-streaming",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    libraryDependencies ++= Seq(
      "org.http4s"    %% "http4s-ember-server" % http4sVersion,
      "org.http4s"    %% "http4s-ember-client" % http4sVersion,
      "org.http4s"    %% "http4s-circe"        % http4sVersion,
      "org.http4s"    %% "http4s-dsl"          % http4sVersion,
      "co.fs2"        %% "fs2-core"            % fs2Version,
      "io.circe"      %% "circe-generic"       % circeVersion,
      "io.circe"      %% "circe-parser"        % circeVersion       % Test,
      "org.typelevel" %% "cats-effect-testkit" % catsEffectVersion  % Test,
      "org.scalameta" %% "munit"               % "1.0.0"            % Test,
      "org.typelevel" %% "munit-cats-effect"   % munitCatsEffectVer % Test,
    )
  )
