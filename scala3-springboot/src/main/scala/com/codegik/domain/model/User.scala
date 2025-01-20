package com.codegik.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.{Column, Table}

import scala.annotation.meta.field

@Table(name = "USER")
case class User(
  @(Id @field)
  id: String,
  
  @(Column @field)
  name: Option[String] = None,

  @(Column @field)
  email: Option[String] = None,
)