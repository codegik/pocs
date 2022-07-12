package com.codegik.poc.javaresilience4j.controller

import com.codegik.poc.javaresilience4j.domain.Cart
import com.codegik.poc.javaresilience4j.domain.Chair
import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.vavr.control.Try
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/shop")
class ShopController {
    private val logger = LoggerFactory.getLogger(ShopController::class.java)

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var circuitBreakerRegistry: CircuitBreakerRegistry

    private val cachedCart = mutableMapOf<String, Cart>()


    @GetMapping
    fun getCartProducts(): ResponseEntity<Cart> {
        val circuitBreaker = circuitBreakerRegistry.circuitBreaker("productService", "productService")

        val decoratedSupplier = CircuitBreaker.decorateSupplier<ResponseEntity<Cart>>(circuitBreaker) {
            val response = restTemplate.getForEntity("/chair", Array<Chair>::class.java)

            logger.info("Requesting external service")

            val cart = Cart(id = "1", products = response.body!!)
            cachedCart[cart.id] = cart

            ok().headers {it.set("isCached", "false")}.body(cart)
        }

        return Try.ofSupplier(decoratedSupplier).recover {
            logger.info("Requesting external service didn't worked, returning cached cart")
            if (cachedCart.containsKey("1")) {
                ok().headers { it.set("isCached", "true") }.body(cachedCart["1"])
            } else {
                ok().headers { it.set("isCached", "false") }.build()
            }
        }.get()
    }
}