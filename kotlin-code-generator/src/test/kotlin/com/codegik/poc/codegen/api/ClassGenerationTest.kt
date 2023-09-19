package com.codegik.poc.codegen.api

import com.codegik.poc.codegen.ClassGenerator
import com.codegik.poc.codegen.ReadDefinition
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClassGenerationTest {
	private val yml = ReadDefinition().fromYml("src/test/resources/sample-app.yml")
	private val classGenerator = ClassGenerator(yml!!)


	@Test
	fun shouldSuccessWhenBuildEntity() {
		val entity = classGenerator.buildEntity()
		val expected1 = "data class Product (val id: String, val description: String)"
		val expected2 = "data class User (val email: String, val fullName: String)"

		assertEquals(expected1, entity[0])
		assertEquals(expected2, entity[1])
	}


	@Test
	fun shouldSuccessWhenBuildRepository() {
		val entity = classGenerator.buildRepository()
		val expected1 = """interface ProductRepository : CrudRepository<Product, String> {
			|   fun findById(id: String): Product?
			|}
		""".trimMargin()

		assertEquals(expected1, entity[0])
	}

}