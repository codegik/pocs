package com.codegik.poc;

import com.codegik.poc.domain.Address;
import com.codegik.poc.repository.AddressRepositoryConcatFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressRepositoryConcatFilterIntegrationTest {

    @Autowired
    private AddressRepositoryConcatFilter repositoryConcatFilter;

    @Test
    void shouldReturnAllAddresses() {
        Iterable<Address> addresses = repositoryConcatFilter.findAll();
        assertThat(addresses).size().isEqualTo(3);
    }

    @Test
    void shouldReturnOneAddressMatchByStreet() {
        List<Address> mainStreetAddresses = repositoryConcatFilter.matchByStreet("Main");
        assertThat(mainStreetAddresses).hasSize(1);
   }

    @Test
    void shouldReturnZeroAddressMatchByStreet() {
        List<Address> mainStreetAddresses = repositoryConcatFilter.matchByStreet("Deleted");
        assertThat(mainStreetAddresses).hasSize(0);
   }
}
