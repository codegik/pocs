package com.codegik.poc.converter
import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class GenericConverterTest {

    private val converter = GenericConverter()

    @Test
    fun personToFriend() {
        val person = Person("Inacio", 38, "me@mail.com")
        val friend = converter.from(person).to(Friend::class.java)

        assertEquals(person.name, friend.name)
        assertEquals(person.age, friend.age)
        assertEquals(person.address, friend.email)

        println("cache size ${converter.cache.size()}")
    }

    @Test
    fun friendToPerson() {
        val friend = Friend("Diego", 55, "email@gmail.com")
        val person = converter.from(friend).to(Person::class.java)

        assertEquals(person.name, friend.name)
        assertEquals(person.age, friend.age)
        assertEquals("email@gmail.com", friend.email)

        println("cache size ${converter.cache.size()}")
    }

    @Test
    fun friendToFriend() {
        val friend = Friend("Diego", 55, "friend@gmail.com")
        val friendClone = converter.from(friend).to(Friend::class.java)

        assertEquals(friendClone.name, friend.name)
        assertEquals(friendClone.age, friend.age)
        assertEquals(friendClone.email, friend.email)

        println("cache size ${converter.cache.size()}")
    }

    @Test
    fun neighborToFriend() {
        val neighbor = Neighbor("Diego", "Jump", "your@gmail.com")
        val friend = converter.from(neighbor).to(Friend::class.java)

        assertEquals(neighbor.name, friend.name)
        assertEquals(neighbor.aim, friend.email)

        println("cache size ${converter.cache.size()}")
    }
}
