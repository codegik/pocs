package com.codegik.observability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);


	public static void main(String[] args) {
		logger.info("Nothing here, please run the tests");
		exit(0);
	}

}
