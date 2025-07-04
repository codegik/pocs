package com.codegik.poc.repository;

import com.codegik.poc.domain.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByStreet(@Param("street") String street);

    @Query("SELECT * FROM address WHERE street LIKE CONCAT('%', :streetPattern, '%')")
    List<Address> matchByStreet(@Param("streetPattern") String streetPattern);
}

