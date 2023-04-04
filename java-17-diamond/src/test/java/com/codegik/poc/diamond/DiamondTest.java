package com.codegik.poc.diamond;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DiamondTest {

	@Test
	void writeLetterA() {
		var expected =
				"""
    			A
    			""";

		assertEquals(expected, new Diamond().write("A"));
	}

	@Test
	void writeLetterB() {
		var expected =
				"""
    			 A
    			B B
    			 A
    			 """;

		assertEquals(expected, new Diamond().write("B"));
	}

	@Test
	void writeLetterD() {
		var expected =
				"""
    			   A
    			  B B
    			 C   C
    			D     D
    			 C   C
    			  B B
    			   A
    			   """;

		assertEquals(expected, new Diamond().write("D"));
	}

	@Test
	void writeLetterL() {
		var expected =
				"""
    			           A
    			          B B
    			         C   C
    			        D     D
    			       E       E
    			      F         F
    			     G           G
    			    H             H
    			   I               I
    			  J                 J
    			 K                   K
    			L                     L
    			 K                   K
    			  J                 J
    			   I               I
    			    H             H
    			     G           G
    			      F         F
    			       E       E
    			        D     D
    			         C   C
    			          B B
    			           A
    			   """;

		assertEquals(expected, new Diamond().write("L"));
	}

	@Test
	void printLetterZ() {
		System.out.println(new Diamond().write("Z"));
	}
}
