package com.laomn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@ServletComponentScan
@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(ThreadConfig.class);
		// AsynTaskService service = context.getBean(AsynTaskService.class);
		//
		// for (int i = 0; i < 10; i++) {
		// service.f1(); // 执行异步任务
		// service.f2();
		// }
		// for (int i = 0; i < 10; i++) {
		// System.out.println("qqqqqqqqqq : " + Thread.currentThread().getName()
		// + " " + i);
		// }
		// context.close();

		// logger.debug("============= SpringBoot Start Success =============");
		// logger.warn("============= SpringBoot Start Success =============");
		// logger.info("============= SpringBoot Start Success =============");
		// logger.error("============= SpringBoot Start Success =============");

	}

}
