package com.laomn.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.laomn.monitor.MonitorController;
import com.laomn.mq.sender.MsgSender;

public class BusinessTask extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(BusinessTask.class);

	private String msg;
	private MsgSender msgSender;

	public BusinessTask(String msg, MsgSender msgSender) {
		this.msg = msg;
		this.msgSender = msgSender;
	}

	public void run() {

		try {
			logger.error("BusinessTask : " + msg);
			// TODO 调用业务代码

			MonitorController.waits.getAndDecrement();
			msgSender.send(msg);
			MonitorController.finishs.addAndGet(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
