package com.codegik.poc.dates

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DatesTest {
	
  val dates = Dates()


  @Test
	fun add60secs() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-03-04 00:01:00"
		assertEquals(result, dates.addSeconds(date, 60))
	}

  @Test
	fun add2min5secs() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-03-04 00:02:05"
		assertEquals(result, dates.addSeconds(date, 125))
	}

  @Test
	fun add1hour() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-03-04 01:00:00"
		assertEquals(result, dates.addSeconds(date, 60 * 60))
	}

  @Test
	fun add3hours() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-03-04 03:00:00"
		assertEquals(result, dates.addSeconds(date, 3 * 60 * 60))
	}

  @Test
	fun add30hours() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-03-05 06:00:00"
		assertEquals(result, dates.addSeconds(date, 30 * 60 * 60))
	}

  @Test
	fun add3days() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-03-07 00:00:00"
		assertEquals(result, dates.addSeconds(date, 3 * 24 * 60 * 60))
	}
  
  @Test
	fun add4months() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2014-07-04 00:00:00"
		assertEquals(result, dates.addSeconds(date, 4 * 30 * 24 * 60 * 60))
	}
  
  @Test
	fun add8years() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2022-03-04 00:00:00"
		assertEquals(result, dates.addSeconds(date, 8 * 12 * 30 * 24 * 60 * 60))
	}
  
  @Test
	fun add8years2months5days14hours31mins45secs() {
    val date    = "2014-03-04 00:00:00"
		val result  = "2022-05-09 14:31:45"
    val year    = 8 * 12 * 30 * 24 * 60 * 60
    val month   = 2 * 30 * 24 * 60 * 60
    val day     = 5 * 24 * 60 * 60
    val hour    = 14 * 60 * 60
    val min     = 31 * 60
    val sec     = 45
		assertEquals(result, dates.addSeconds(date, (year + month + day + hour + min + sec).toLong()))
	}
}
