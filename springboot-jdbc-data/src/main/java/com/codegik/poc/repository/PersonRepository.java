package com.codegik.poc.repository;

import com.codegik.poc.domain.Person;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import java.util.Collections;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("SELECT * FROM person WHERE id IN (:ids)")
    List<Person> findByIdInOption1(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE (:ids)::bigint[] IS NULL OR id = ANY((:ids)::bigint[])")
    List<Person> findByIdInOption2(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE id IN (:ids)")
    List<Person> findByIdInOption3Raw(@Param("ids") List<Long> ids);

    default List<Person> findByIdInOption3(List<Long> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        return findByIdInOption3Raw(ids);
    }

    @Query("SELECT * FROM person WHERE (:#{#ids.isEmpty()} = false AND id IN (:ids))")
    List<Person> findByIdInOption4(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE (1=0 OR id IN (:ids))")
    List<Person> findByIdInOption5(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person p WHERE EXISTS (SELECT 1 FROM unnest(CAST(:ids AS bigint[])) AS i(id) WHERE p.id = i.id) OR cardinality(:ids) = 0")
    List<Person> findByIdInOption6(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE " +
            "(:#{#ids == null} = true) OR " +
            "(:#{#ids.isEmpty()} = true) OR " +
            "id IN (:#{#ids})")
    List<Person> findByIdInOption7(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE (:#{#ids == null} = true) OR id IN (:#{#ids})")
    List<Person> findByIdInOption8(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE id IN (:#{#ids})")
    List<Person> findByIdInOption9(@Param("ids") List<Long> ids);

    @Query("SELECT * FROM person WHERE array_length(:ids::bigint[], 1) IS NULL OR id IN (:ids)")
    List<Person> findByIdInOption10(@Param("ids") List<Long> ids);
}
