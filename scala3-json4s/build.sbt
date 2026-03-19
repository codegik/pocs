name := "scala3-json4s"

version := "0.1.0"

scalaVersion := "3.3.1"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-native" % "4.0.7",
  "org.json4s" %% "json4s-jackson" % "4.0.7",
  "org.scalatest" %% "scalatest" % "3.2.17" % Test
)

Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat
