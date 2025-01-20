package com.codegik.repository

import com.codegik.domain.model.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait UserRepository extends CrudRepository[User, String] {

  @Query("SELECT * FROM user WHERE name like '%:name%'")
  def findByName(name: String): List[User]

}