package com.codegik.service

import com.codegik.config.DataSourceConfig
import io.getquill.*
import zio.{ZIO, ZLayer}

import java.sql.SQLException
import java.util.UUID
import javax.sql.DataSource

case class InputData(
                      id: String = UUID.randomUUID().toString,
                      value: Int,
                      name: String)

class DataService {
  val ds: DataSource = DataSourceConfig().dataSource()
  val ctx: PostgresZioJdbcContext[SnakeCase.type] = new PostgresZioJdbcContext(SnakeCase)
  import ctx.*


  def getAll: ZIO[Any, Throwable, List[InputData]] =
    ctx.run(query[InputData])
      .provide(ZLayer.succeed(ds))

  def insert(data: InputData): ZIO[Any, SQLException, Long] =
    ctx.run(quote{query[InputData].insertValue(lift(data))})
      .provide(ZLayer.succeed(ds))
}
