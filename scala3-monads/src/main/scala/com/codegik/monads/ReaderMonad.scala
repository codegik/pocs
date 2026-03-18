package com.codegik.monads

// Reader[R, A] wraps a function  R => A  — given a shared environment R, produce a value A.

final case class Reader[R, A](run: R => A) {

  def map[B](f: A => B): Reader[R, B] =
    Reader(r => f(run(r)))

  def flatMap[B](f: A => Reader[R, B]): Reader[R, B] =
    Reader(r => f(run(r)).run(r))

  /** Provide the environment and execute. */
  def provide(env: R): A = run(env)

  /** Pre-process the environment before running.
    * Useful for narrowing or transforming a larger config into a smaller one.
    */
  def local[R2](f: R2 => R): Reader[R2, A] =
    Reader(r2 => run(f(r2)))
}

object Reader {
  def pure[R, A](a: A): Reader[R, A] = Reader(_ => a)

  /** Access the whole environment. */
  def ask[R]: Reader[R, R] = Reader(identity)

  /** Access a projection of the environment. */
  def asks[R, A](f: R => A): Reader[R, A] = Reader(f)
}

// Demo
object ReaderDemo {

  // Shared environment / config
  case class AppConfig(
    appName: String,
    env: String,
    dbHost: String,
    dbPort: Int,
    maxConnections: Int
  )

  // Reads just the DB portion — demonstrates `local`
  case class DbConfig(host: String, port: Int, maxConnections: Int)

  val appName: Reader[AppConfig, String] = Reader.asks(_.appName)
  val envName:  Reader[AppConfig, String] = Reader.asks(_.env)

  def buildConnectionString(db: DbConfig): String =
    s"jdbc:postgresql://${db.host}:${db.port}"

  val connectionString: Reader[DbConfig, String] =
    Reader.asks(buildConnectionString)

  val greeting: Reader[AppConfig, String] =
    for {
      name <- appName
      env  <- envName
    } yield s"[$name] running in $env"

  val fullReport: Reader[AppConfig, String] =
    for {
      header  <- greeting
      connStr <- connectionString.local[AppConfig](c =>
        DbConfig(c.dbHost, c.dbPort, c.maxConnections)
      )
      maxConn <- Reader.asks[AppConfig, Int](_.maxConnections)
    } yield s"""$header
               |  db  : $connStr
               |  pool: $maxConn connections""".stripMargin

  def run(): Unit = {
    println("\n=== Reader Monad ===")

    val config = AppConfig(
      appName        = "scala3-monads",
      env            = "production",
      dbHost         = "db.example.com",
      dbPort         = 5432,
      maxConnections = 10
    )

    val report = fullReport.provide(config)
    println(report.linesIterator.map(l => s"  [Reader] $l").mkString("\n"))
  }
}
