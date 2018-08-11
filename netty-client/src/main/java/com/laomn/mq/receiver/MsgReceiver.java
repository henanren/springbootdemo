package com.laomn.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.laomn.client.inner.InnerClient;
import com.laomn.threads.BusinessTask;
import com.laomn.threads.ThreadPool;
import com.laomn.utils.Constants;

@Component
@RabbitListener(queues = Constants.QUEUE)
public class MsgReceiver {

	@Autowired
	private InnerClient innerClient;
	@Value("${inner.client.host}")
	private String host;
	@Value("${inner.client.port}")
	private int port;

	@RabbitHandler
	public void process(String msg) {
		System.out.println("Receiver  : " + msg);
		ThreadPool.POOL.execute(new BusinessTask(innerClient, msg));
	}

}