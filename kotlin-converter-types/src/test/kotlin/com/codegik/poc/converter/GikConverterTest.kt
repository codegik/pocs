package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import org.junit.jupiter.api.Test

class GikConverterTest {

	private val converter = GikConverter()


	@Test
	fun neighborToFriend() {
		val neighbor = Neighbor("Diego", "Jump", "email@gmail.com")
		val friend = converter.from(neighbor).to(Friend::class)

	}
}
