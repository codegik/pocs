package com.codegik.slick

import slick.jdbc.H2Profile.api.*
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class UserRepository(db: SlickDb):

  def insert(user: User): Future[Long] =
    db.run((Tables.users returning Tables.users.map(_.id)) += user)

  def insertAll(users: Seq[User]): Future[Seq[Long]] =
    db.run((Tables.users returning Tables.users.map(_.id)) ++= users)

  def findById(id: Long): Future[Option[User]] =
    db.run(Tables.users.filter(_.id === id).result.headOption)

  def findByEmail(email: String): Future[Option[User]] =
    db.run(Tables.users.filter(_.email === email).result.headOption)

  def findByName(name: String): Future[Seq[User]] =
    db.run(Tables.users.filter(_.name === name).result)

  def findByAgeRange(min: Int, max: Int): Future[Seq[User]] =
    db.run(Tables.users.filter(u => u.age >= min && u.age <= max).result)

  def findAll(): Future[Seq[User]] =
    db.run(Tables.users.result)

  def update(user: User): Future[Int] =
    db.run(Tables.users.filter(_.id === user.id).update(user))

  def updateEmail(id: Long, newEmail: String): Future[Int] =
    db.run(Tables.users.filter(_.id === id).map(_.email).update(newEmail))

  def delete(id: Long): Future[Int] =
    db.run(Tables.users.filter(_.id === id).delete)

  def count(): Future[Int] =
    db.run(Tables.users.length.result)

  def existsByEmail(email: String): Future[Boolean] =
    db.run(Tables.users.filter(_.email === email).exists.result)

  def findSortedByName(ascending: Boolean = true): Future[Seq[User]] =
    val q = if ascending then Tables.users.sortBy(_.name.asc)
            else Tables.users.sortBy(_.name.desc)
    db.run(q.result)

  def findPaginated(offset: Int, limit: Int): Future[Seq[User]] =
    db.run(Tables.users.sortBy(_.id.asc).drop(offset).take(limit).result)

  def findOlderThan(age: Int): Future[Seq[User]] =
    db.run(Tables.users.filter(_.age > age).result)
