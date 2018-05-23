package com.laomn.filter;

import java.io.IOException;
import java.io.PrintWriter;

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

import com.alibaba.fastjson.JSONObject;
import com.laomn.Application;
import com.laomn.common.TenantContextHolder;

@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		logger.info("=====before chain.doFilter=====");
		try {
			HttpServletRequest rep = (HttpServletRequest) request;
			String code = rep.getParameter("code");
			if ("1".equals(code)) {

				TenantContextHolder.setTenant("company1");
			} else if ("2".equals(code)) {
				TenantContextHolder.setTenant("company2");
			} else if ("3".equals(code)) {
				TenantContextHolder.setTenant("company3");
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				JSONObject res = new JSONObject();
				res.put("success", "false");
				res.put("msg", "你无权访问系统。");
				PrintWriter out = response.getWriter();
				out.append(res.toString());
				return;
			}
			chain.doFilter(request, response);
		} finally {
			TenantContextHolder.remove();
		}
		logger.info("=====after chain.doFilter=====");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
