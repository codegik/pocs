package com.codegik.poc.repository;

import com.codegik.poc.domain.AddressActive;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressActiveRepository extends CrudRepository<AddressActive, Long> {
}
