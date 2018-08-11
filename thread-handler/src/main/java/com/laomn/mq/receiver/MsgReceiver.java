package com.laomn.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.laomn.threads.BusinessTask;
import com.laomn.threads.ThreadPool;
import com.laomn.utils.Constants;

@Component
@RabbitListener(queues = Constants.RECEIVE_QUEUE)
public class MsgReceiver {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("Receiver  : " + msg);
		ThreadPool.POOL.execute(new BusinessTask(msg));
	}

}