package com.codegik.poc.github.service

import com.spotify.github.v3.clients.GitHubClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.net.URI


@Service
class GithubService {
    private val logger = LoggerFactory.getLogger(GithubService::class.java)


    fun getPRs() {
        val githubClient = GitHubClient.create(URI.create("https://api.github.com/"),"")


    }
}