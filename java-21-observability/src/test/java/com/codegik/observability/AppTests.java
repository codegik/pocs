package com.codegik.observability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

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


	@Test
	void shouldRegisterMetricPercentiles() {
		final Random r = new Random();
		for (int i = 0; i < 100; i++) {
			measureLatency("sleep", () -> {
				sleep(r.nextInt(100));
				return true;
			});
		}

		var metricsMap = metricsMap();

		assertEquals(100, metricsMap.get("sleep.latency.success"));
		assertTrue(metricsMap.get("sleep.latency.p50") < metricsMap.get("sleep.latency.p90"));
		assertTrue(metricsMap.get("sleep.latency.p90") < metricsMap.get("sleep.latency.p99"));
	}


	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
