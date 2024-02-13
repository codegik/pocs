package com.codegik.logger.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class LoggerConfig {

    @Value("{logger.fileName:application.log}")
    lateinit var fileName: String;

    @Value("{logger.isAsync:true}")
    lateinit var isAsync: java.lang.Boolean;

}
