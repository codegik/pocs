package com.codegik.poc.validation

import com.codegik.poc.validation.domain.Person
import com.codegik.poc.validation.service.ServiceFactory
import com.codegik.poc.validation.service.PersonService
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidationTest {

	@Test
	fun saveShouldSuccess() {
		val service = ServiceFactory.instance(PersonService::class)
		val person = service.save(Person("John", 223, "mail"))

		assertEquals(person.email, service.findByName("John").first().email)
	}
}
