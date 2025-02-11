package com.codegik.service

import com.codegik.Application
import com.codegik.dao.UserDao
import com.codegik.domain.model.User
import com.jayway.jsonpath.{JsonPath, PathNotFoundException}
import org.junit.jupiter.api.Assertions.{assertEquals, assertNull, assertThrows}
import org.junit.jupiter.api.{Assertions, Test}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

import java.net.{URI, URI as url}
import java.net.http.{HttpClient, HttpRequest, HttpResponse}

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = Array(classOf[Application])
)
class UserControllerTest @Autowired()(
  val userDao: UserDao,
  val httpClient: HttpClient,
) {

  @LocalServerPort
  var randomServerPort: Int = 0

  @Test
  def shouldInsertUsersAndFilterByName(): Unit = {
    val user1 = userDao.save(User(name = "John"))
    val user2 = userDao.save(User(name = "Jane"))
    val user3 =  userDao.save(User(name = "Mary"))

    val url = s"http://localhost:$randomServerPort/user"
    val response = httpClient.send(
      HttpRequest.newBuilder()
        .uri(URI(url))
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .GET()
        .build(),
      HttpResponse.BodyHandlers.ofString()
    )

    val json = JsonPath.parse(response.body())
    assertEquals(200, response.statusCode())
    assertEquals("John", json.read("$[0].name"))
    assertThrows(classOf[PathNotFoundException], () => json.read("$[0].email"))
  }

}
