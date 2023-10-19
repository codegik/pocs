package com.codegik.poc.minion.rest

import com.codegik.poc.minion.model.StressTestConfig
import java.net.Socket
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.*
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLEngine
import javax.net.ssl.TrustManager
import javax.net.ssl.X509ExtendedTrustManager
import kotlin.concurrent.thread


class RestClient(private val test: StressTestConfig) {


    fun start(): Boolean {
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(trustManager), SecureRandom())

        val httpClient = HttpClient.newBuilder().sslContext(sslContext).build()

        thread {
            for (i in 1.rangeTo(test.times)) {
                val uri = "${test.url}?nc=${UUID.randomUUID()}"

                print("[Minion] Test: calling $uri ${i}/${test.times} ")

                try {
                    val request = HttpRequest.newBuilder().uri(URI(uri)).GET().build()
                    val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
                    println("got ${response.statusCode()}")
                } catch (e: Exception) {
                    println("got error ${e.message}")
                }
            }
        }

        return true
    }


    private val trustManager: TrustManager = object: X509ExtendedTrustManager() {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?, engine: SSLEngine?) { }
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) { }
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?, socket: Socket?) { }
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?, engine: SSLEngine?) { }
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) { }
        override fun getAcceptedIssuers(): Array<X509Certificate> { return arrayOf() }
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?, socket: Socket?) { }
    }
}
