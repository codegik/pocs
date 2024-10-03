val zioVersion = "2.1.9"

scalaVersion := "3.3.2"
name := "zio-scala-stream"
version := "0.0.1"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-streams" % zioVersion
)


