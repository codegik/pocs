package com.codegik.poc.billionaires;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

	@Test
	public void resultShouldBeOne() {
		List<List<Integer>> result = new App().threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
		assertEquals(expected, result);
	}


	@Test
	public void resultShouldBeZero() {
		List<List<Integer>> result = new App().threeSum(new int[] {0, 1, 1});
		List<List<Integer>> expected = Arrays.asList();
		assertEquals(expected, result);
	}


	@Test
	public void resultShouldBeOneWhenInputIsZero() {
		List<List<Integer>> result = new App().threeSum(new int[] {0, 0, 0});
		List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 0, 0));
		assertEquals(expected, result);
	}
}
