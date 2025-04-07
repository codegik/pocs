package com.codegik.service

import com.codegik.Application
import com.codegik.dao.UserDao
import com.codegik.domain.model.{AdminRole, DevRole, User}
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows, assertTrue, fail}
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.relational.core.conversion.DbActionExecutionException

import java.util.UUID

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = Array(classOf[Application])
)
class RoleTest @Autowired()(
  val userDao: UserDao
) {

  @Test
  def shouldRoleConverterTakeAction(): Unit = {
    userDao.save(User(name = "John", role = new AdminRole {}))
    userDao.save(User(name = "Jane", role = new DevRole {}))

    val user1 = userDao.findByName("John")
    val user2 = userDao.findByName("Jane")

    user1.head.role match {
      case _: AdminRole => assertTrue(true)
      case _ => fail("It should result in AdminRole")
    }
    user2.head.role match {
      case _: DevRole => assertTrue(true)
      case _ => fail("It should result in DevRole")
    }
  }
}
