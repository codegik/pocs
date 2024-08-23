package com.codegik.netty.config

import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import reactor.core.scheduler.Schedulers
import reactor.netty.channel.ChannelMetricsRecorder
import reactor.netty.channel.MicrometerChannelMetricsRecorder
import reactor.netty.http.client.HttpClient
import reactor.netty.http.server.HttpServer
import java.util.function.Supplier


@Configuration
class NettyWebFluxConfig {

//    @Bean
//    fun nettyServerCustomizer2(): NettyServerCustomizer {
//        return NettyServerCustomizer { httpServer: HttpServer ->
//            httpServer.doOnBind { config ->
//                config.loopResources()
//                    .onServer(httpServer.configuration().isPreferNative)
//                    .forEach { eventExecutor ->
//                        if (eventExecutor is SingleThreadEventExecutor) {
//                            var singleThreadEventExecutor = eventExecutor as SingleThreadEventExecutor;
//                            Gauge.builder("server_pending_task", singleThreadEventExecutor::pendingTasks)
//                                .description("Pending Tasks")
//                                .tag("server_thread_name", singleThreadEventExecutor.threadProperties().name())
//                                .tag("server_thread_state", singleThreadEventExecutor.threadProperties().state().name)
//                                // TODO find out what netty register is using to add entry there (.register())l
//                        }
//                    }
//            }
//        }
//    }


//    @Bean
//    fun nettyServerCustomizer(): NettyServerCustomizer {
//        return NettyServerCustomizer { httpServer: HttpServer ->
//            httpServer.metrics(true,
//                Supplier<ChannelMetricsRecorder> {
//                    MicrometerHttpServerMetricsRecorder
//                })
//        }
//    }

//    @Bean
//    fun nettyServerCustomizer(): NettyServerCustomizer {
//        Metrics.globalRegistry
//            .config()
//            .meterFilter(MeterFilter.maximumAllowableTags("reactor.netty.http.server", "URI", 100, MeterFilter.deny()));
//
//
//        return NettyServerCustomizer { httpServer: HttpServer ->
//
//            httpServer.metrics(true) { s: String ->
//                if (s.startsWith("/stream/")) {
//                    return@metrics "/stream/{n}"
//                } else if (s.startsWith("/bytes/")) {
//                    return@metrics "/bytes/{n}"
//                }
//                s
//            }
//        }
//    }

    @Bean
    fun nettyServerCustomizer(): NettyServerCustomizer {
        Schedulers.enableMetrics()
        return NettyServerCustomizer { httpServer: HttpServer ->
            httpServer.metrics(true,
                Supplier<ChannelMetricsRecorder> { MicrometerChannelMetricsRecorder("MY_SERVICE", "MY_SERVICE") })
        }
    }

    @Bean
    fun getReactorClientHttpConnector(): ReactorClientHttpConnector {
        return ReactorClientHttpConnector(
            HttpClient.create().wiretap(true).metrics
                (
                true,
                Supplier<ChannelMetricsRecorder> { MicrometerChannelMetricsRecorder("myservicename", "myservicename") })
        )
    }

}
