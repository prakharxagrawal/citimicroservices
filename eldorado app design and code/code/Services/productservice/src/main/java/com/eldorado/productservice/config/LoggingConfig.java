package com.eldorado.productservice.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoggingConfig {
	private static final Logger log = Logger.getLogger(LoggingConfig.class.getName());

	public static Logger getLog() {
		return log;
	}

}

