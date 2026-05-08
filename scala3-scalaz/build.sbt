name := "scala3-scalaz-poc"
version := "0.1.0"
scalaVersion := "3.3.1"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.3.8",
  "org.scalatest" %% "scalatest" % "3.2.17" % Test
)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)
