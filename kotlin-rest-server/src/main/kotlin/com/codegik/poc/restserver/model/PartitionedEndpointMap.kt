package com.codegik.poc.restserver.model

import com.codegik.poc.restserver.handler.HttpRequestHandler
import com.codegik.poc.restserver.handler.NotFoundRequestHandler
import com.codegik.poc.restserver.handler.RequestHandler
import java.util.concurrent.ConcurrentHashMap

class PartitionedEndpointMap {
    private val oneParamEndpointMap = ConcurrentHashMap<Pair<String, String>, RequestHandler>()
    private val twoParamEndpointMap = ConcurrentHashMap<Pair<String, String>, RequestHandler>()
    private val threeParamEndpointMap = ConcurrentHashMap<Pair<String, String>, RequestHandler>()
    private val manyParamEndpointMap = ConcurrentHashMap<Pair<String, String>, RequestHandler>()
    private val mappedMatchPatterns = ConcurrentHashMap<String, Regex>()
    private val pathVariablePattern = """\{[^}]*\}""".toRegex()
    private val pathVariableReplacement = "([a-zA-Z0-9%]+)"


    fun put(count: Int, pair: Pair<String, String>, httpRequestHandler: HttpRequestHandler): Boolean {
        when (count) {
            1 -> oneParamEndpointMap[pair] = httpRequestHandler
            2 -> twoParamEndpointMap[pair] = httpRequestHandler
            3 -> threeParamEndpointMap[pair] = httpRequestHandler
            else -> manyParamEndpointMap[pair] = httpRequestHandler
        }

        if (pair.second.contains("{")) {
            var endpointPattern = pair.second.replace("/", "\\/")

            pathVariablePattern.findAll(pair.second).forEach { variable ->
                endpointPattern = endpointPattern.replace(variable.value, pathVariableReplacement)
            }

            mappedMatchPatterns[pair.second] = endpointPattern.toRegex()
        }

        return true
    }


    fun get(httpRequest: HttpRequest): RequestHandler {
        mappedMatchPatterns.forEach { (endpoint, pathParamPattern) ->
            val matchKey = Pair("${httpRequest.method}", endpoint)
            if (pathParamPattern.matches(httpRequest.endpoint)) {
                val pathParameters = pathParamPattern.findAll(httpRequest.endpoint)
                    .map { it.groupValues }
                    .filter { it.size > 1 }
                    .flatMap { it.subList(1, it.size)}
                    .toList()
                val httpRequestEnchant = httpRequest.copy(pathParameters = pathParameters)
                val endpointMap = get(pathParameters.size, matchKey) ?: return NotFoundRequestHandler()

                endpointMap?.httpRequest(httpRequestEnchant)

                return endpointMap
            }
        }

        return NotFoundRequestHandler()
    }


    private fun get(count: Int, pair: Pair<String, String>): RequestHandler? {
        return when (count) {
            1 -> oneParamEndpointMap[pair]
            2 -> twoParamEndpointMap[pair]
            3 -> threeParamEndpointMap[pair]
            else -> manyParamEndpointMap[pair]
        }
    }
}