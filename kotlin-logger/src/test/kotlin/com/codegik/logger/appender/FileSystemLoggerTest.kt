package com.codegik.logger.appender

import com.codegik.logger.config.LoggerConfig
import org.junit.jupiter.api.Test
import java.io.File

class FileSystemLoggerTest {

	@Test
	fun teste1() {
		val fileName = LoggerConfig.fileName()
		val logger = FileSystemLogger(FileSystemLoggerTest::class.java)

		logger.info("first message")

		File(fileName).delete()
	}

}
