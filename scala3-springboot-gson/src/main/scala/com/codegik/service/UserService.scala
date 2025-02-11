package com.codegik.service

import com.codegik.dao.UserDao
import com.codegik.domain.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired() (
  private val userDao: UserDao
){

  def findAll(): List[User] = {
    userDao.findAll()
  }

}