package com.codegik.poc.codegen.api

import com.codegik.poc.codegen.ReadDefinition
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReadDefinitionTest {


	@Test
	fun shouldSuccessWhenReadYml() {
		val yml = ReadDefinition().fromYml("src/test/resources/sample-app.yml")

		assertEquals("Product", yml!!.app.domains[0].name)
		assertEquals("id", yml!!.app.domains[0].fields[0].name)
		assertEquals("String", yml!!.app.domains[0].fields[0].type)
		assertEquals(true, yml!!.app.domains[0].fields[0].isKey)
		assertEquals("description", yml!!.app.domains[0].fields[1].name, )
		assertEquals("String", yml!!.app.domains[0].fields[1].type)
		assertEquals(false, yml!!.app.domains[0].fields[1].isKey)
		assertEquals("User", yml!!.app.domains[1].name)

		assertEquals("Product", yml!!.app.controllers[0].domain)
		assertEquals("GET", yml!!.app.controllers[0].methods[0])
		assertEquals("POST", yml!!.app.controllers[0].methods[1])
	}


	@Test
	fun shouldSuccessWhenCheckConstraints() {
		val definition = ReadDefinition()
		val yml = definition.fromYml("src/test/resources/sample-app.yml")
		val validationResult = definition.checkConstraints(yml!!)

		assertEquals(true, validationResult.success)
		assertEquals(0, validationResult.violations.size)
	}


	@Test
	fun shouldFailWhenControllerIsNotInDomainList() {
		val definition = ReadDefinition()
		val yml = definition.fromYml("src/test/resources/sample-app-fail-1.yml")
		val validationResult = definition.checkConstraints(yml!!)

		assertEquals(false, validationResult.success)
		assertEquals("Controller 'InvalidDomainName' is not in domain list", validationResult.violations[0])
	}


	@Test
	fun shouldFailWhenDomainDoesntHaveKeyField() {
		val definition = ReadDefinition()
		val yml = definition.fromYml("src/test/resources/sample-app-fail-2.yml")
		val validationResult = definition.checkConstraints(yml!!)

		assertEquals(false, validationResult.success)
		assertEquals("Domain 'Product' doesn't have a key field", validationResult.violations[0])
	}

}