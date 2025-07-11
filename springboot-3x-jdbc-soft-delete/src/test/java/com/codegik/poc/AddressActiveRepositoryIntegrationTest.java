package com.codegik.poc;

import com.codegik.poc.domain.AddressActive;
import com.codegik.poc.repository.AddressActiveRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressActiveRepositoryIntegrationTest {

    @Autowired
    private AddressActiveRepository repository;

    @Test
    void shouldReturnOnlyActiveAddresses() {
        Iterable<AddressActive> addresses = repository.findAll();
        assertThat(addresses).size().isEqualTo(3);
    }
}
