package com.codegik.service

import com.codegik.config.DataSourceConfig
import io.getquill.*
import zio.{ZIO, ZLayer}

import javax.sql.DataSource

case class Person(id: Int, name: String, age: Int)

class PersonService {
  val ds: DataSource = DataSourceConfig().dataSource()
  val ctx: PostgresZioJdbcContext[SnakeCase.type] = new PostgresZioJdbcContext(SnakeCase)
  import ctx.*


  def getAll: ZIO[Any, Throwable, List[Person]] =
    ctx.run(query[Person])
      .provide(ZLayer.succeed(ds))

  def insert(person: Person): ZIO[Any, Throwable, Int] =
    ctx.run(query[Person].insertValue(lift(person))
      .returningGenerated(_.id))
      .provide(ZLayer.succeed(ds))

}
