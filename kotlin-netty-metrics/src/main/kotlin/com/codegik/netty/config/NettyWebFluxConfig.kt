package com.codegik.netty.config

import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.netty.channel.ChannelMetricsRecorder
import reactor.netty.channel.MicrometerChannelMetricsRecorder
import reactor.netty.http.server.HttpServer
import java.util.function.Supplier

@Configuration
class NettyWebFluxConfig {

    @Bean
    fun nettyServerCustomizer(): NettyServerCustomizer {
        return NettyServerCustomizer { httpServer: HttpServer ->
            httpServer.metrics(true,
                Supplier<ChannelMetricsRecorder> {
                    MicrometerChannelMetricsRecorder(
                        "myapp",
                        "myapp"
                    )
                })
//            httpServer.metrics(true)
        }
    }

}