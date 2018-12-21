package com.laomn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		// ConfigurableApplicationContext run =
		// SpringApplication.run(ClientApplication.class, args);
		// CityDubboConsumerService cityService =1`
		// run.getBean(CityDubboConsumerService.class);
		// cityService.printCity();
		int i = 0;
		List<Object> list = new ArrayList<Object>();
		// long s = System.currentTimeMillis();
		while (true) {
			// i--;
			// if ((System.currentTimeMillis() - s) / 1000 == 1)
			// break;
			list.add(new ClientApplication());
			System.out.println(i++);
		}

		// Collections.unmodifiableList();
		// System.out.println(i);

	}
}
