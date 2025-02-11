package com.codegik.repository

import com.codegik.domain.model.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
trait UserRepository extends CrudRepository[User, String] {

  @Query("SELECT u.* FROM Users u WHERE u.name = :name")
  def findByName(name: String): java.util.List[User]

}