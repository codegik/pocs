package com.codegik.exception

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class GlobalExceptionHandlerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc


    @Test
    fun `should return http 500 Caught by GlobalExceptionHandler with taskExecutor`() {
        mockMvc.perform(get("/api/sync-current-time-error"))
            .andExpect(status().is5xxServerError)
            .andExpect(jsonPath("$.error").value("Caught by GlobalExceptionHandler"))
            .andExpect(jsonPath("$.status").value(500))
            .andExpect(jsonPath("$.message").value("Simulated sync error"))
    }


    @Test
    fun `should return http 500 Caught by GlobalExceptionHandler with taskExecutor BigDecimal`() {
        mockMvc.perform(get("/api/async-current-time-error-big-decimal"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.error").value("Caught by GlobalExceptionHandler"))
            .andExpect(jsonPath("$.status").value(500))
            .andExpect(jsonPath("$.message").value("Simulated sync error"))
    }


    @Test
    fun `should return http 200 NOT Caught by GlobalExceptionHandler with taskExecutor`() {
        mockMvc.perform(get("/api/async-current-time-error"))
            .andExpect(status().isOk())
    }

}
