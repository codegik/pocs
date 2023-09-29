package com.codegik.observability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codegik.observability.Metrics.measureLatency;
import static com.codegik.observability.Metrics.metricsMap;
import static com.codegik.observability.Metrics.reset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AppTests {

	@BeforeEach
	void cleanUp() {
		reset();
	}


	@Test
	void shouldRegisterMetricAndReturnTheFunctionResult() {
		var result = measureLatency("arrays", () -> {
			sleep(4);
			return "returned from caller's function";
        });

		var metricsMap = metricsMap();

		assertEquals("returned from caller's function", result);
		assertEquals(1, metricsMap.get("arrays.latency.total"));
		assertEquals(0, metricsMap.get("arrays.latency.errors"));
		assertEquals(1, metricsMap.get("arrays.latency.success"));
		assertTrue(0 < metricsMap.get("arrays.latency.avg"));
	}


	@Test
	void shouldRegisterMetricWhenFunctionThrowsException() {
		assertThrows(RuntimeException.class, () -> {
			measureLatency("anything", () -> {
				sleep(4);
				throw new RuntimeException("any exception");
			});
		}, "any exception");

		var metricsMap = metricsMap();

		assertEquals(1, metricsMap.get("anything.latency.total"));
		assertEquals(1, metricsMap.get("anything.latency.errors"));
		assertEquals(0, metricsMap.get("anything.latency.success"));
		assertTrue(0 < metricsMap.get("anything.latency.avg"));
	}


	private void sleep(Integer time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
