package com.codegik.domain.api

case class UserResponse(
  id: String, 
  name: Option[String], 
  email: Option[String],
)
