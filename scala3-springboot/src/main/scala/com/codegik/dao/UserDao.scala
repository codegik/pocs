package com.codegik.dao

import com.codegik.domain.model.User
import com.codegik.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import scala.jdk.CollectionConverters.*

@Component
class UserDao @Autowired() (
  private val userRepository: UserRepository
) {

  def findAll(): List[User] = {
    userRepository.findAll().asScala.toList
  }
  
  def save(user: User): User = {
    userRepository.save(user)
  }
  
  def findByName(name: String): List[User] = {
    userRepository.findByName(name).asScala.toList
  }

}
