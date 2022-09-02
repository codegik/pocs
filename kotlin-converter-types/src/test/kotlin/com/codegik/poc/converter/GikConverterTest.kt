package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GikConverterTest {

	private val converter = GikConverter()


	@Test
	fun neighborToFriend() {
		val neighbor = Neighbor("Diego", "Jump", "email@gmail.com")
		val friend = converter.from(neighbor).to(Friend::class)

		assertEquals(friend.name, neighbor.name)
		assertEquals(friend.age, null)
		assertEquals(friend.email, neighbor.aim)
	}
}
