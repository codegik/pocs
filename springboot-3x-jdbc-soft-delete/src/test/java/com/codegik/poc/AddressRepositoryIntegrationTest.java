package com.codegik.poc;

import com.codegik.poc.domain.Address;
import com.codegik.poc.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressRepositoryIntegrationTest {

    @Autowired
    private AddressRepository repository;

    @Test
    void shouldReturnAllAddresses() {
        Iterable<Address> addresses = repository.findAll();
        assertThat(addresses).size().isEqualTo(4);
    }

    @Test
    void shouldReturnOneAddressMatchByStreet() {
        List<Address> mainStreetAddresses = repository.matchByStreet("Main");
        assertThat(mainStreetAddresses).hasSize(1);
   }

    @Test
    void shouldReturnZeroAddressMatchByStreet() {
        List<Address> mainStreetAddresses = repository.matchByStreet("Deleted");
        assertThat(mainStreetAddresses).hasSize(1);
   }
}
