package com.laomn;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.laomn.mq.sender.MsgSender;
import com.laomn.utils.MenuUtils;

@ServletComponentScan
@SpringBootApplication
@Controller
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model, HttpServletRequest request) {
		MenuUtils.setMenu(model, "first");
		return "index";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private MsgSender msgSender;

	// @PostConstruct
	public void test() {
		for (int i = 0; i < 100; i++)
			msgSender.send("qqq :   " + new Date().getTime());
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		logger.info("============= SpringBoot Start Success =============");
	}

}
