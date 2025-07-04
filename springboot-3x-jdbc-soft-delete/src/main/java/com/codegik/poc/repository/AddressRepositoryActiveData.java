package com.codegik.poc.repository;

import com.codegik.poc.domain.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepositoryActiveData extends CrudRepository<Address, Long> {

    @Query("SELECT * FROM active_address")
    @Override
    List<Address> findAll();

    List<Address> findByStreet(@Param("street") String street);

    @Query("SELECT * FROM active_address WHERE street LIKE CONCAT('%', :streetPattern, '%')")
    List<Address> matchByStreet(@Param("streetPattern") String streetPattern);
}

