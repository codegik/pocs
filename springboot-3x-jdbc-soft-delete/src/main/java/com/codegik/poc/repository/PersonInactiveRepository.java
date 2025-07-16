package com.codegik.poc.repository;

import com.codegik.poc.domain.PersonInactive;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonInactiveRepository extends CrudRepository<PersonInactive, Long> {

    List<PersonInactive> findByName(@Param("name") String name);

    @Query("SELECT * FROM person_inactive WHERE name LIKE CONCAT('%', :namePattern, '%')")
    List<PersonInactive> matchByName(@Param("namePattern") String namePattern);
}
