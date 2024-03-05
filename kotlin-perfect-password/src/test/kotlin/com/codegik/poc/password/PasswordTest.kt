package com.codegik.poc.password

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PasswordTest {

    @Test
    fun longestSubStringShouldResult7() {
        // The longest substring without repeating characters are “ABCDEFG”, “BCDEFGA”, and “CDEFGAB” with lengths of 7
        val result = Password().lengthOfLongestSubstring("ABCDEFGABEF")
        assertEquals(7, result)
    }


    @Test
    fun longestSubStringShouldResult6() {
        // The longest substrings without repeating characters are “ANDORI”, with lengths of 6
        val result = Password().lengthOfLongestSubstring("RANDORIDOJO")
        assertEquals(6, result)
    }

    @Test
    fun lengthMustBe32() {
        val result = Password().isPerfectPass("RANDORIDOJO")
        assertFalse(result)
    }

    @Test
    fun exclamationMarkIsForbidden() {
        val result = Password().isPerfectPass("RANDORIDOJORANDOR!DOJORANDORIDOJ")
        assertFalse(result)
    }

    @Test
    fun twoCapitalCharsAtLeast() {
        assertFalse(Password().isPerfectPass("randoridojorandoridojorandoridoj"))
        assertFalse(Password().isPerfectPass("Randoridojorandoridojorandoridoj"))
    }

    @Test
    fun twoNumbersAtLeast() {
        assertFalse(Password().isPerfectPass("RandoridojorandoridojorandoridoJ"))
        assertFalse(Password().isPerfectPass("Randor1dojorandoridojorandoridoJ"))
    }

    @Test
    fun twoSpecialCharsAtLeast() {
        assertFalse(Password().isPerfectPass("Randor1dojorandorid0jorandorid0J"))
        assertFalse(Password().isPerfectPass("Randor1do#orandorid0jorandorid0J"))
    }

    @Test
    fun longestSubStringGreaterThan26() {
        assertFalse(Password().isPerfectPass("Rand#r123456789acefghijalmRtu*xz"))
        assertTrue(Password().isPerfectPass("Rand#r123456789bcefghijklmRtu*xz"))
    }

}
