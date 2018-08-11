package com.laomn.mq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.laomn.utils.Constants;

//@RabbitListener(queues = Constants.SEND_QUEUE)
@Component
@RabbitListener(queues = Constants.RECEIVE_QUEUE)
public class MsgReceiver {
	private static final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

	@RabbitHandler
	public void process(String msg) {
		logger.error("Receiver  : " + msg);

	}

}