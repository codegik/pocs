val scala3Version = "3.2.1"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "scala-js-keyboard-drive",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    scalaJSUseMainModuleInitializer := true,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.1.0"
  )
