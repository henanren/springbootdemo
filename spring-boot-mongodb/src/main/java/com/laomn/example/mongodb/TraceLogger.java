package com.laomn.example.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TraceLogger {
	// 此处的"tranceLog"为log4j中定义的对应的 logger的name
	private static final Logger TRACE_LOGGER = LoggerFactory.getLogger(TraceLogger.class);

	private TraceLogger() {

	}

	public static void info(String message) {
		TRACE_LOGGER.info(message);
	}

	public static void info(String format, Object... arguments) {
		TRACE_LOGGER.info(format, arguments);
	}

	public static void main(String args[]) {
		MDC.clear();
		MDC.put("sessionId", "f9e287fad9e84cff8b2c2f2ed92adbe6");
		MDC.put("cityId", "1");
		MDC.put("siteName", "北京");
		MDC.put("userName", "userwyh");
		TraceLogger.info("测试MDC打印一");

		MDC.put("mobile", "110");
		TraceLogger.info("测试MDC打印二");

		MDC.put("mchId", "12");
		MDC.put("mchName", "商户名称");
		TraceLogger.info("测试MDC打印三");
	}
}