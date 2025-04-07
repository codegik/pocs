package com.codegik.controllers

import com.codegik.domain.api.UserResponse
import com.codegik.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

import scala.jdk.CollectionConverters.*

@RestController
@RequestMapping(Array("/user/"))
class UserController @Autowired()(
  private val userService: UserService
) {

  @GetMapping(Array(""))
  def getAll: ResponseEntity[List[UserResponse]] = {
    userService.findAll().map(u => UserResponse(u.id, u.name, u.email)) match {
      case Nil => ResponseEntity.notFound().build()
      case users => ResponseEntity.ok(users)
    }
  }
}