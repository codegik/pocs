package com.codegik.domain.api

import java.util.UUID

case class UserResponse(
  id: UUID, 
  name: String = null, 
  email: String = null,
)
