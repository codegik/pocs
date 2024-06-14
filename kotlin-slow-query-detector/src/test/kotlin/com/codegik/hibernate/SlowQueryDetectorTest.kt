package com.codegik.hibernate

import com.codegik.hibernate.domain.Person
import com.codegik.hibernate.repository.PersonRepository
import com.codegik.hibernate.service.HibernateStatisticsService
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID
import kotlin.random.Random

@SpringBootTest
class SlowQueryDetectorTest(
	@Autowired private val personRepository: PersonRepository,
	@Autowired private val hibernateStatisticsService: HibernateStatisticsService,
) {

	protected val logger: Log = LogFactory.getLog(javaClass)

	@BeforeEach
	fun setup() {
		val persons = List(100000) { Person(UUID.randomUUID(), UUID.randomUUID().toString(), Random.nextInt()) }
		personRepository.saveAll(persons)
	}

    @Test
	fun showAllQueriesSortedByTimeTaken() {
		personRepository.findById(UUID.randomUUID())
		logger.info("Showing queries by time taken:\n${hibernateStatisticsService.publish()}")
		personRepository.findByAge(87654)
		logger.info("Showing queries by time taken:\n${hibernateStatisticsService.publish()}")
		personRepository.findByName("John")
		logger.info("Showing queries by time taken:\n${hibernateStatisticsService.publish()}")
	}

    @Test
	fun showTop3SlowestQueries() {
		personRepository.findAll()
		personRepository.findByAge(Random.nextInt())
		personRepository.findByName("John")
		personRepository.findByName("John")
		personRepository.findByName(UUID.randomUUID().toString())

		val queries = hibernateStatisticsService.top3SlowestQueries()

		assertEquals(3, queries.size)
	}

}
