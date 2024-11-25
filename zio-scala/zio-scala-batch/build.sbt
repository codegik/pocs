scalaVersion := "3.4.3"
name := "zio-scala-batch"
version := "0.0.1"

libraryDependencies ++= Seq(
  "dev.zio"         %% "zio"            % "2.1.9",
  "io.getquill"     %% "quill-jdbc-zio" % "4.8.6",
  "org.postgresql"  %  "postgresql"     % "42.7.4",
)
