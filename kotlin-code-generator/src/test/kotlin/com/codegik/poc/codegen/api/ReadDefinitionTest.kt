package com.codegik.poc.codegen.api

import com.codegik.poc.codegen.ReadDefinition
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReadDefinitionTest {


	@Test
	fun shouldSuccess() {
		val definition = ReadDefinition().fromYml("src/test/resources/sample-app.yml")

		assertEquals(definition!!.app.name, "sample-generated-app")
	}

}