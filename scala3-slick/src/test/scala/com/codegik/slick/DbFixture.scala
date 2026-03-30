package com.codegik.slick

import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api.*
import scala.concurrent.Await
import scala.concurrent.duration.*
import java.util.UUID

trait DbFixture:
  // Each suite gets its own in-memory DB (unique URL = isolated)
  private val dbName = UUID.randomUUID().toString.replace("-", "")

  val db: SlickDb = H2Profile.api.Database.forURL(
    url    = s"jdbc:h2:mem:$dbName;DB_CLOSE_DELAY=-1",
    driver = "org.h2.Driver"
  )

  val userRepo  = UserRepository(db)
  val orderRepo = OrderRepository(db)

  def await[T](f: scala.concurrent.Future[T]): T =
    Await.result(f, 10.seconds)

  def createSchema(): Unit =
    await(db.run(Tables.schema.createIfNotExists))

  def dropSchema(): Unit =
    await(db.run(Tables.schema.dropIfExists))

  def resetSchema(): Unit =
    dropSchema()
    createSchema()
