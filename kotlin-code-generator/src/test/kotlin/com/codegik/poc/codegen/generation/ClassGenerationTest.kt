package com.codegik.poc.codegen.generation

import com.codegik.poc.codegen.definition.ReadDefinition
import com.codegik.poc.codegen.generator.ClassGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClassGenerationTest {
	private val yml = ReadDefinition().fromYml("src/test/resources/sample-app.yml")
	private val classGenerator = ClassGenerator(yml!!)


	@Test
	fun shouldSuccessWhenBuildEntity() {
		val entities = classGenerator.buildEntity()
		val expected1 =
			"""package com.generated
			|
			|data class Product (val id: String, val description: String)""".trimMargin()
		val expected2 =
			"""package com.generated
			|
			|data class User (val email: String, val fullName: String)""".trimMargin()

		assertEquals(expected1, entities[0].fileContent)
		assertEquals(expected2, entities[1].fileContent)
	}


	@Test
	fun shouldSuccessWhenBuildRepository() {
		val repositories = classGenerator.buildRepository()
		val expected1 =
			"""package com.generated
			|
			|interface ProductRepository : CrudRepository<Product, String> {
			|   fun findById(id: String): Product?
			|}""".trimMargin()

		assertEquals(expected1, repositories[0].fileContent)
	}


	@Test
	fun shouldSuccessWhenBuildService() {
		val services = classGenerator.buildService()
		val expected1 =
			"""package com.generated
			|
			|class ProductService(private val repository: ProductRepository> {
			|   fun findById(id: String): Product? {
			|       return repository.findById(id)
			|   }
			|   fun findAll(): List<Product> {
			|       return repository.findAll()
			|   }
			|   fun save(product: Product): Product {
			|       return repository.save(product)
			|   }
			|}""".trimMargin()

		assertEquals(expected1, services[0].fileContent)
	}

}