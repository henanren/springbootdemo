package com.laomn.filter;

/**
 * 
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @类名 AuthFilter.java
 * @作者 如慶
 * @创建日期 2016年7月15日
 * @描述
 * @版本 V 1.0
 */
@WebFilter(urlPatterns = "/*", filterName = "appFilter")
public class AuthFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		String s = httpServletRequest.getParameter("code");
		if ("1".equals(s)) {
			MDC.put("code", "daohoaxiang");
		} else if ("2".equals(s)) {
			MDC.put("code", "daohoaxiang");
		} else if ("3".equals(s)) {
			MDC.put("code", "mengniu");
		} else {
			MDC.put("code", "xmht");
		}

		logger.info(s + " :   filter");

		logger.debug(s + " :   filter");
		logger.warn(s + " :   filter");
		logger.info(s + " :   filter");
		logger.error(s + " :   filter");
		filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {
	}

}
