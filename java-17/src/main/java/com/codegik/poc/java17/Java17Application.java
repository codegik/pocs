package com.codegik.poc.java17;

import com.codegik.poc.java17.sealed.Circle;
import com.codegik.poc.java17.sealed.Form;
import com.codegik.poc.java17.sealed.Rectangle;
import com.codegik.poc.java17.sealed.TransparentRectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SUNDAY;

@SpringBootApplication
public class Java17Application implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(Java17Application.class);


	public static void main(String[] args) {
		SpringApplication.run(Java17Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Form rectangle = new Rectangle();
		Form circle = new Circle();
		TransparentRectangle transparentRectangle = new TransparentRectangle();
		Switch patternMatch = new Switch();

		logger.info(rectangle.print());
		logger.info(circle.print());
		logger.info(transparentRectangle.print());
		logger.info(patternMatch.fill("text"));
		logger.info(patternMatch.fill(45));
		logger.info(patternMatch.fill(00001L));

		logger.info("is work day? {}", patternMatch.isWorkDay(FRIDAY));
		logger.info("is work day? {}", patternMatch.isWorkDay(SUNDAY));
		logger.info("LCD print 123456789 -> {}", new LCD().printNumber("123456789"));
		logger.info("LCD print 1103 -> {}", new LCD().printNumber("1103"));
	}
}
