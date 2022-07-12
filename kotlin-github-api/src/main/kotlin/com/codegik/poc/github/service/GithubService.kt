package com.codegik.poc.github.service

import com.spotify.github.v3.clients.GitHubClient
import com.spotify.github.v3.prs.requests.ImmutablePullRequestParameters
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.net.URI
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAmount
import java.time.temporal.TemporalUnit


@Service
class GithubService {
    private val logger = LoggerFactory.getLogger(GithubService::class.java)

    @Value("\${github.uri:https://github.tlcinternal.com/api/v3}")
    private lateinit var uri: String

    @Value("\${github.user:username}")
    private lateinit var user: String

    @Value("\${github.accessToken:hashtoken}")
    private lateinit var accessToken: String

    @Value("\${github.repositories}")
    private lateinit var repositories: List<String>


    fun findLastWeekPRs() {
        var prsStr = ""
        val sevenDaysAgo = Instant.now().minus(7, ChronoUnit.DAYS);
        val closedFilter = ImmutablePullRequestParameters.builder().state("closed").build()

        repositories.forEach { repository ->
            val (org, repo) = repository.split("/").let { Pair(it[0], it[1]) }
            val prClient = GitHubClient.create(URI.create(uri), accessToken)
                .createRepositoryClient(org, repo)
                .createPullRequestClient()

            // finding closed PRs
            prClient.list(closedFilter).join()
                .filter { it.user()?.login().equals(user) }
                .filter { it.createdAt()?.instant()?.isAfter(sevenDaysAgo) == true }
                .forEach { prsStr += "\n${it.htmlUrl()}" }

            // finding open PRs
            prClient.list().join()
                .filter { it.user()?.login().equals(user) }
                .filter { it.createdAt()?.instant()?.isAfter(sevenDaysAgo) == true }
                .forEach { prsStr += "\n${it.htmlUrl()}" }
        }

        logger.info("Last Week PRs from {} {}", user, prsStr)
    }
}