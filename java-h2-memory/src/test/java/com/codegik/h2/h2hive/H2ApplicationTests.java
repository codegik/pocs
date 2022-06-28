package com.codegik.h2.h2hive;

import com.codegik.h2.h2hive.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class H2ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String rootUrl = "http://localhost:";


	@Test
	void chargeback() {
		Transaction[] transactions = restTemplate.getForObject(rootUrl + port + "/chargeback/2022-03-01", Transaction[].class);
		assertThat(transactions).hasSize(3);
	}


	@Test
	void fedReturns() {
		Transaction[] transactions = restTemplate.getForObject(rootUrl + port + "/fedreturns/2022-03-01", Transaction[].class);
		assertThat(transactions).hasSize(1);
	}


	@Test
	void accountsWithFedReturns() {
		Transaction[] transactions = restTemplate.getForObject(rootUrl + port + "/accountswithfedreturns/2022-03-01", Transaction[].class);
		assertThat(transactions).hasSize(1);
	}

}
