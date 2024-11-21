package com.codegik.config

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

import javax.sql.DataSource

class DataSourceConfig {
  private val hikariConfig = new HikariConfig()
  hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/items")
  hikariConfig.setUsername("postgres")
  hikariConfig.setPassword("12345")
  private val ds: DataSource = new HikariDataSource(hikariConfig)
  
  def dataSource(): DataSource = ds
}
