package com.codegik.grpc.service;

import com.codegik.grpc.repository.UserRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Test configuration for gRPC integration tests
 * Provides beans needed for testing without starting the actual gRPC server
 */
@TestConfiguration
public class GrpcTestConfiguration {

    @Bean
    @Primary
    public UserGrpcService userGrpcService(UserRepository userRepository) {
        return new UserGrpcService(userRepository);
    }
}
