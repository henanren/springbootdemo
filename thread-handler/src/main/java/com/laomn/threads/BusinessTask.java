package com.laomn.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BusinessTask extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(BusinessTask.class);

	private String msg;

	public BusinessTask(String msg) {
		this.msg = msg;

	}

	public void run() {

		try {
			logger.info("BusinessTask : " + msg);
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
