package com.laomn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		logger.debug("============= SpringBoot Start Success =============");
		logger.warn("============= SpringBoot Start Success =============");
		logger.info("============= SpringBoot Start Success =============");
		logger.error("============= SpringBoot Start Success =============");
	}

}
