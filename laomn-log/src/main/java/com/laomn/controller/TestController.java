package com.laomn.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.ConfigService;
import com.laomn.apollo.AnnotatedBean;

@RestController
@RequestMapping("/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private AnnotatedBean annotatedBean;

	@RequestMapping(method = RequestMethod.GET, value = { "/t" })
	public String index(HttpServletRequest request, Map<String, Object> model) {
		// String s = request.getParameter("c");
		// logger.info(s + " : 测试日志");
		//
		// logger.debug(s + " : IndexController 测试日志");
		// logger.warn(s + " : IndexController 测试日志");
		// logger.info(s + " : IndexController 测试日志");
		// logger.error(s + " : IndexController 测试日志");
		//
		logger.error(" annotatedBean.getTimeout() =  " + annotatedBean.getTimeout());
		logger.error(" annotatedBean.getTimeout()--2222 =  "
				+ ConfigService.getAppConfig().getProperty("test", "undefined"));
		return annotatedBean.getTimeout() + "";
	}

}
