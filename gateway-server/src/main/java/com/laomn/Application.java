package com.laomn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laomn.mq.sender.MsgSender;
import com.laomn.utils.PropertieUtils;

//@ServletComponentScan
@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	// @Autowired
	private MsgSender msgSender;

	// @PostConstruct
	public void test() {
		for (int i = 0; i < 100; i++)
			msgSender.send("11111");
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("java.io.tmpdir", "D:\\eclipse-jee-luna-SR2-win32-x86_64\\eclipse\\ttttt");
		SpringApplication.run(Application.class, args);

		// SpringUtils.getBean(OuterServer.class).init();

		logger.info("============= SpringBoot Start Success =============");
		System.out.println(PropertieUtils.getValueFromZhou_PClog("log4j.appender.TCPINFO.File"));
	}

}
