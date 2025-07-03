package com.codegik.poc.repository;

import com.codegik.poc.domain.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepositoryConcatFilter extends CrudRepository<Address, Long> {
    String NOT_DELETED = " is_soft_deleted = false ";

    @Query("SELECT * FROM address WHERE " + NOT_DELETED)
    @Override
    List<Address> findAll();

    @Query("SELECT * FROM address WHERE " + NOT_DELETED + " AND street = :street")
    List<Address> findByStreet(@Param("street") String street);

    @Query("SELECT * FROM address WHERE " + NOT_DELETED + " AND street LIKE CONCAT('%', :streetPattern, '%')")
    List<Address> matchByStreet(@Param("streetPattern") String streetPattern);
}


