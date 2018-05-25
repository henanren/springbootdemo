package com.laomn;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
//@ComponentScan(basePackages = { "org.apache.ibatis.mapping" })
@SpringBootApplication(scanBasePackages = { "org.apache.ibatis", "com.laomn" })
// @RequestMapping("/")
@RestController
// @EnableAutoConfiguration
@MapperScan("com.laomn.dao")
@EnableTransactionManagement
@ServletComponentScan
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("============= SpringBoot Start Success =============");
	}

	@RequestMapping("/2")
	public String test2() {
		logger.info("==================业务处理===================");
		return "2";
	}

}
