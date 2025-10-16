package com.example.webflux;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.channel.ChannelMetricsRecorder;
import reactor.netty.channel.MicrometerChannelMetricsRecorder;
import reactor.netty.http.client.HttpClient;

import java.util.function.Supplier;

@Configuration
public class NettyMetricsConfig {

    @Autowired
    private MeterRegistry meterRegistry;

    @Bean
    public NettyServerCustomizer nettyServerCustomizer() {
        return (httpServer) -> httpServer.metrics(
                true,
                new Supplier<ChannelMetricsRecorder>() {
                    @Override
                    public ChannelMetricsRecorder get() {
                        return new MicrometerChannelMetricsRecorder("reactor.netty", "http");
                    }
                }
        );
    }

    @Bean
    public ReactorClientHttpConnector getReactorClientHttpConnector() {
        return new ReactorClientHttpConnector(
                HttpClient
                        .create()
                        .wiretap(true)
                        .metrics(
                                true,
                                new Supplier<ChannelMetricsRecorder>() {
                                    @Override
                                    public ChannelMetricsRecorder get() {
                                        return new MicrometerChannelMetricsRecorder("reactor.netty.client", "http");
                                    }
                                }
                        )
        );
    }
}
