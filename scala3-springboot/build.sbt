
name := "scala3-springboot"
version := "1.0"
scalaVersion := "3.6.2"
organization := "com.codegik"

val springBootVersion = "3.4.1"
val javaVersion = "21"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.18.2",
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-jdbc" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-data-jdbc" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion % Test,
  "com.h2database" % "h2" % "2.3.232" % Runtime
)

javacOptions ++= Seq(
  "--release", javaVersion,
  "--enable-preview",
  "--add-opens=java.base/java.lang=ALL-UNNAMED",
  "--add-opens=java.base/java.util=ALL-UNNAMED",
)

Compile / mainClass := Some("com.codegik.Application")