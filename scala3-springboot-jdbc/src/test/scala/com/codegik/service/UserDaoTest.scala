package com.codegik.service

import com.codegik.Application
import com.codegik.dao.UserDao
import com.codegik.domain.model.User
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows}
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.relational.core.conversion.DbActionExecutionException

import java.util.UUID

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = Array(classOf[Application])
)
class UserDaoTest @Autowired()(
  val userDao: UserDao
) {

  @Test
  def shouldInsertUsersAndFilterByName(): Unit = {
    userDao.save(User(name = "John"))
    userDao.save(User(name = "Jane"))
    userDao.save(User(name = "Mary"))

    val user1 = userDao.findByName("John")
    val user2 = userDao.findByName("Jane")
    val user3 = userDao.findByName("Mary")

    assertEquals("John", user1.head.name)
    assertEquals("Jane", user2.head.name)
    assertEquals("Mary", user3.head.name)
  }


  @Test
  def shouldUpdateUser(): Unit = {
    val user = userDao.save(User(name = "John"))
    val updatedUser = userDao.save(user.copy(name = "Jane"))

    assertEquals("Jane", updatedUser.name)
  }


  @Test
  def shouldFailTryingToUpdateUserThatDoesntExists(): Unit = {
    assertThrows(
      classOf[DbActionExecutionException], 
      () => userDao.save(User(id = UUID.randomUUID(), name = "John"))
    )
  }

}
