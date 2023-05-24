package com.eldorado.authservice.config;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * Logger Configration Class
 */

@Configuration
public class LoggerConfig {

	
	/**
	 * Initializing Logger Object
	 */

	private static final Logger log = Logger.getLogger(LoggerConfig.class.getName());

	/**
	 * @return logger object
	 */
	public static Logger getLog() {
		return log;
	}

}