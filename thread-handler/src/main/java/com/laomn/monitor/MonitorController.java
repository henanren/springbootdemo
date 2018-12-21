package com.laomn.monitor;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.laomn.threads.ThreadPool;
import com.laomn.utils.MenuUtils;

@Controller
@RequestMapping("/monitor")
public class MonitorController {
	private static final Logger logger = LoggerFactory.getLogger(MonitorController.class);
	// 待处理的队列数
	public static AtomicInteger waits = new AtomicInteger(0);
	// 已经完成的队列数
	public static AtomicInteger finishs = new AtomicInteger(0);
	@Autowired
	private RestTemplate restTemplate;

	@Value("${netty.server.http.host}")
	private String host;

	@RequestMapping(value = "/queue", method = RequestMethod.GET)
	public String queue(Map<String, Object> model, HttpServletRequest request) {
		logger.info("queue");
		model.put("waits", waits.get());
		model.put("finishs", finishs.get());

		MenuUtils.setMenu(model, "queue");
		return "monitor/queue";
	}

	@RequestMapping(value = "/thread", method = RequestMethod.GET)
	public String thread(Map<String, Object> model, HttpServletRequest request) {
		int threadCount = ((ThreadPoolExecutor) ThreadPool.POOL).getActiveCount();
		model.put("runs", threadCount);

		int corePoolSize = ((ThreadPoolExecutor) ThreadPool.POOL).getCorePoolSize();
		model.put("threads", corePoolSize);

		MenuUtils.setMenu(model, "thread");
		return "monitor/thread";
	}

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set(Map<String, Object> model, HttpServletRequest request) {
		String s = request.getParameter("kw");
		logger.info("线程数 ： " + s);
		int threadCount = ((ThreadPoolExecutor) ThreadPool.POOL).getActiveCount();
		model.put("runs", threadCount);
		int corePoolSize = Integer.parseInt(s);
		((ThreadPoolExecutor) ThreadPool.POOL).setCorePoolSize(corePoolSize);
		model.put("threads", corePoolSize);

		MenuUtils.setMenu(model, "thread");
		return "monitor/thread";
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String status(Map<String, Object> model, HttpServletRequest request) {
		boolean flag = false;
		String status = this.restTemplate.getForObject(host, String.class);
		if ("0".equals(status)) {
			flag = true;
		}
		if (flag)
			model.put("status", 0);
		else
			model.put("status", 1);

		MenuUtils.setMenu(model, "status");
		return "monitor/status";
	}

}
