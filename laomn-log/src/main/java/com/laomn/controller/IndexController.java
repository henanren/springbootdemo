package com.laomn.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(method = RequestMethod.GET, value = { "/" })
	public String index(HttpServletRequest request, Map<String, Object> model) {
		String s = request.getParameter("c");
		logger.info(s + "    : 测试日志");

		logger.debug(s + " :   IndexController  测试日志");
		logger.warn(s + " :   IndexController  测试日志");
		logger.info(s + " :   IndexController  测试日志");
		logger.error(s + " :   IndexController  测试日志");
		return "index";
	}

}
