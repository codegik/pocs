package com.codegik.logger.appender

import com.codegik.logger.config.LoggerConfig
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File
import java.lang.Thread.sleep

class FileSystemLoggerTest {

	@Test
	fun messagesShouldBePresentInFile() {
		val fileName = LoggerConfig.fileName()
		val logger1 = FileSystemLogger(FileSystemLoggerTest::class.java)
		val logger2 = FileSystemLogger(LoggerConfig::class.java)

		logger1.info("first message")
		logger2.info("second message")

		sleep(100)

		val content = File(fileName).readText(Charsets.UTF_8)

		assertTrue(content.contains("[INFO] [com.codegik.logger.appender.FileSystemLoggerTest] first message"))
		assertTrue(content.contains("[INFO] [com.codegik.logger.config.LoggerConfig] second message"))

		File(fileName).delete()
	}

}
