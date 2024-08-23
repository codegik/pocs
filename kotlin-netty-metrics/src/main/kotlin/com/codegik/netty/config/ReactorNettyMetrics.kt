package com.codegik.netty.config

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.MeterBinder
import org.springframework.stereotype.Component
import reactor.netty.ReactorNetty

@Component
class ReactorNettyMetrics : MeterBinder {
    override fun bindTo(registry: MeterRegistry) {
        registry.gauge("reactor.netty.ioWorkerCount", System.getProperty(ReactorNetty.IO_WORKER_COUNT, "4").toInt())
        registry.gauge("reactor.netty.udp.ioThreadCount", System.getProperty(ReactorNetty.UDP_IO_THREAD_COUNT, "4").toInt())
        registry.gauge("reactor.netty.pool.maxConnections", System.getProperty(ReactorNetty.POOL_MAX_CONNECTIONS, "16").toInt())
    }
}