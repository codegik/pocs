package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.UUID;

@Component
public class CorrelationIdFilter implements WebFilter {
    private static final Logger logger = LoggerFactory.getLogger(CorrelationIdFilter.class);
    private static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
    private static final String CORRELATION_ID_KEY = "correlationId";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String correlationId = exchange.getRequest()
                .getHeaders()
                .getFirst(CORRELATION_ID_HEADER);

        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }

        final String finalCorrelationId = correlationId;

        exchange.getResponse()
                .getHeaders()
                .add(CORRELATION_ID_HEADER, finalCorrelationId);

        logger.info("Request received with correlation ID: {}", finalCorrelationId);

        return chain.filter(exchange)
                .contextWrite(Context.of(CORRELATION_ID_KEY, finalCorrelationId))
                .doOnSuccess(v -> logger.info("Request completed with correlation ID: {}", finalCorrelationId))
                .doOnError(e -> logger.error("Request failed with correlation ID: {}", finalCorrelationId, e));
    }

    public static String getCorrelationId() {
        return Mono.deferContextual(ctx ->
                Mono.just(ctx.getOrDefault(CORRELATION_ID_KEY, "NO_CORRELATION_ID"))
        ).block();
    }

    public static Mono<String> getCorrelationIdMono() {
        return Mono.deferContextual(ctx ->
                Mono.just(ctx.getOrDefault(CORRELATION_ID_KEY, "NO_CORRELATION_ID"))
        );
    }
}
