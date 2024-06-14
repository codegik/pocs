package com.codegik.hibernate.service

import jakarta.persistence.EntityManagerFactory
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class HibernateStatisticsService(
    @Autowired private val entityManagerFactory: EntityManagerFactory
) {
    private val queries = mutableMapOf<String, Long>()

    private fun collectStats(): Map<String, Long> {
        val statistics = entityManagerFactory.unwrap(SessionFactory::class.java).statistics

        statistics.queries.forEach { query ->
            val metaData = statistics.getQueryStatistics(query)
            val took = metaData.executionTotalTime
            queries[query.replace("[CRITERIA] ", "")] = took
        }

        return queries
    }

    fun publish(): String {
        return collectStats()
            .toSortedMap(compareByDescending { it })
            .map { "${it.key} took ${it.value}ms" }
            .joinToString("\n")
    }

    fun top3SlowestQueries(): Map<String, Long> {
        return collectStats()
            .toList()
            .sortedBy { (_, value) -> value}
            .reversed()
            .toMap()
    }
}