package com.laomn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.laomn.dubbo.CityDubboConsumerService;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
		CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
		cityService.printCity();
	}
}
