package com.codegik.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.{Column, Table}

import java.util.UUID
import scala.annotation.meta.field

@Table(name = "USERS")
case class User(
  @(Id @field)
  id: UUID = null,

  @(Column @field)
  name: String = null,

  @(Column @field)
  email: String = null,
)