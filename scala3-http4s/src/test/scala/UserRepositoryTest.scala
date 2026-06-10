package com.codegik.http4s

import cats.effect.IO
import munit.CatsEffectSuite

class UserRepositoryTest extends CatsEffectSuite:

  private val alice = UserInput("Alice", "alice@example.com", 30)
  private val bob   = UserInput("Bob", "bob@example.com", 25)

  test("empty repo has no users") {
    for
      repo  <- UserRepository.empty[IO]
      users <- repo.all
      n     <- repo.count
    yield
      assertEquals(users, Nil)
      assertEquals(n, 0)
  }

  test("create assigns incrementing ids starting at 1") {
    for
      repo <- UserRepository.empty[IO]
      a    <- repo.create(alice)
      b    <- repo.create(bob)
    yield
      assertEquals(a.id, 1L)
      assertEquals(b.id, 2L)
      assertEquals(a.name, "Alice")
  }

  test("create stores the user so it can be found") {
    for
      repo  <- UserRepository.empty[IO]
      a     <- repo.create(alice)
      found <- repo.find(a.id)
    yield assertEquals(found, Some(a))
  }

  test("all returns users sorted by id") {
    for
      repo  <- UserRepository.empty[IO]
      _     <- repo.create(alice)
      _     <- repo.create(bob)
      users <- repo.all
    yield assertEquals(users.map(_.id), List(1L, 2L))
  }

  test("find returns None for an unknown id") {
    for
      repo  <- UserRepository.empty[IO]
      found <- repo.find(999L)
    yield assertEquals(found, None)
  }

  test("update replaces fields but keeps the id") {
    for
      repo    <- UserRepository.empty[IO]
      a       <- repo.create(alice)
      updated <- repo.update(a.id, UserInput("Alice Cooper", "ac@example.com", 31))
    yield
      assertEquals(updated.map(_.id), Some(a.id))
      assertEquals(updated.map(_.name), Some("Alice Cooper"))
      assertEquals(updated.map(_.age), Some(31))
  }

  test("update returns None for an unknown id") {
    for
      repo <- UserRepository.empty[IO]
      res  <- repo.update(42L, alice)
    yield assertEquals(res, None)
  }

  test("delete removes an existing user and returns true") {
    for
      repo    <- UserRepository.empty[IO]
      a       <- repo.create(alice)
      deleted <- repo.delete(a.id)
      found   <- repo.find(a.id)
    yield
      assertEquals(deleted, true)
      assertEquals(found, None)
  }

  test("delete returns false for an unknown id") {
    for
      repo    <- UserRepository.empty[IO]
      deleted <- repo.delete(7L)
    yield assertEquals(deleted, false)
  }

  test("ids keep increasing even after deletes") {
    for
      repo <- UserRepository.empty[IO]
      a    <- repo.create(alice)
      _    <- repo.delete(a.id)
      b    <- repo.create(bob)
    yield assertEquals(b.id, 2L)
  }

  test("count reflects the number of stored users") {
    for
      repo <- UserRepository.empty[IO]
      _    <- repo.create(alice)
      _    <- repo.create(bob)
      _    <- repo.delete(1L)
      n    <- repo.count
    yield assertEquals(n, 1)
  }

  test("seeded repo exposes the provided users with ids from 1") {
    for
      repo  <- UserRepository.seeded[IO](List(alice, bob))
      users <- repo.all
    yield
      assertEquals(users.map(_.id), List(1L, 2L))
      assertEquals(users.map(_.name), List("Alice", "Bob"))
  }

  test("seeded repo assigns the next id after the seed") {
    for
      repo <- UserRepository.seeded[IO](List(alice, bob))
      c    <- repo.create(UserInput("Carol", "carol@example.com", 40))
    yield assertEquals(c.id, 3L)
  }

  test("concurrent creates all succeed with distinct ids") {
    import cats.syntax.parallel.*
    for
      repo <- UserRepository.empty[IO]
      _    <- (1 to 50).toList.parTraverse(i =>
                repo.create(UserInput(s"u$i", s"u$i@example.com", 20)))
      n    <- repo.count
      ids  <- repo.all.map(_.map(_.id).toSet)
    yield
      assertEquals(n, 50)
      assertEquals(ids.size, 50)
  }
