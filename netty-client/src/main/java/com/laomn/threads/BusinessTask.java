package com.laomn.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.laomn.client.inner.InnerClient;

@Component
public class BusinessTask extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(BusinessTask.class);

	private InnerClient innerClient;

	private String msg;

	public BusinessTask(InnerClient innerClient, String msg) {
		this.innerClient = innerClient;
		this.msg = msg;

	}

	public void run() {

		try {
			logger.info("BusinessTask : " + msg);
			innerClient.sendMsg(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
