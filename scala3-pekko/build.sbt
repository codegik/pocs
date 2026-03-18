name := "scala3-pekko"

version := "0.1.0"

scalaVersion := "3.6.3"

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor-typed" % "1.1.2",
  "org.apache.pekko" %% "pekko-http" % "1.1.0",
  "org.apache.pekko" %% "pekko-stream" % "1.1.2",
  "org.apache.pekko" %% "pekko-actor-testkit-typed" % "1.1.2" % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test
)
