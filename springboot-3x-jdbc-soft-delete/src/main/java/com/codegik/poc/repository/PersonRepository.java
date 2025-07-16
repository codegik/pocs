package com.codegik.poc.repository;

import com.codegik.poc.domain.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(@Param("name") String name);

    @Override
    @Modifying
    @Query(value = "INSERT INTO person_inactive SELECT * FROM person WHERE id = :id; DELETE FROM person WHERE id = :id")
    void deleteById(@Param("id") Long id);

    @Override
    default void delete(Person person) {
        deleteById(person.getId());
    }

    @Override
    default void deleteAll(Iterable<? extends Person> entities) {
        entities.forEach(this::delete);
    }

    @Override
    @Modifying
    @Query(value = "INSERT INTO person_inactive SELECT * FROM person; DELETE FROM person")
    void deleteAll();
}
