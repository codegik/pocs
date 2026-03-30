package com.codegik.slick

import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api.*
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.*

// Convenience alias used throughout the POC
type SlickDb = H2Profile.backend.Database

object Database:
  def inMemory(): SlickDb =
    H2Profile.api.Database.forURL(
      url    = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL",
      driver = "org.h2.Driver"
    )

  def await[T](f: Future[T], timeout: Duration = 10.seconds): T =
    Await.result(f, timeout)
