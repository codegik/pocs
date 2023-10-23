package com.codegik.poc.minion.model

data class StressTestConfig(
    val url: String,
    val times: Int,
    val numberUsers: Int
)