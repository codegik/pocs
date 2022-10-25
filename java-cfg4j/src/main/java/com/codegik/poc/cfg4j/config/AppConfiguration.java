package com.codegik.poc.cfg4j.config;

import com.codegik.poc.cfg4j.properties.GitDbProperties;
import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;
import org.cfg4j.source.git.GitConfigurationSourceBuilder;
import org.cfg4j.source.reload.strategy.PeriodicalReloadStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;
import java.util.Arrays;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class AppConfiguration {

    @Value("${configuration.uri}")
    private String configurationURI;

    @Value("${configuration.environment}")
    private String configurationEnvironment;

    @Bean
    public ConfigurationProvider defaultAppProperties() {
        final ConfigurationSource source = new GitConfigurationSourceBuilder()
                .withRepositoryURI(configurationURI)
                .build();

        final ConfigurationProvider provider = new ConfigurationProviderBuilder()
                .withConfigurationSource(source)
                .withReloadStrategy(new PeriodicalReloadStrategy(5, SECONDS))
                .build();

        return provider;
    }


    @Bean
    public GitDbProperties environmentAppProperties() {
        final ConfigFilesProvider configFilesProvider = () ->
                Arrays.asList(Paths.get("firstApp/" + configurationEnvironment + "/feature/configuration.yaml"));
        final ConfigurationSource source = new GitConfigurationSourceBuilder()
                .withRepositoryURI(configurationURI)
                .withConfigFilesProvider(configFilesProvider)
                .build();

        final ConfigurationProvider provider = new ConfigurationProviderBuilder()
                .withConfigurationSource(source)
                .withReloadStrategy(new PeriodicalReloadStrategy(5, SECONDS))
                .build();

        return provider.bind("databasePool", GitDbProperties.class);
    }
}
