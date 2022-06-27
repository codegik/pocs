package com.codegik.poc.cfg4j;

import com.codegik.poc.cfg4j.properties.GitDbProperties;
import org.cfg4j.provider.ConfigurationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(App.class);

	@Autowired
	private ConfigurationProvider gitDefaultProperties;

	@Autowired
	private GitDbProperties gitDbProperties;



	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("gitDefaultProperties [some.setting] -> {}", gitDefaultProperties.getProperty("some.setting", String.class));
		logger.info("gitDefaultProperties [some.other.setting] -> {}", gitDefaultProperties.getProperty("some.other.setting", String.class));
		logger.info("gitDbProperties [databasePool.url] -> {}", gitDbProperties.url());
		logger.info("gitDbProperties [databasePool.maxPoolSize] -> {}", gitDbProperties.maxPoolSize());
		logger.info("gitDbProperties [databasePool.connectionTimeoutMs] -> {}", gitDbProperties.connectionTimeoutMs());

		System.exit(0);
	}
}
