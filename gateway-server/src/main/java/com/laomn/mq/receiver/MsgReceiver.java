package com.laomn.mq.receiver;

import io.netty.channel.Channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laomn.netty.client.OuterClient;
import com.laomn.utils.Constants;

// @RabbitListener(queues = Constants.SEND_QUEUE)
@Component
@RabbitListener(queues = Constants.RECEIVE_QUEUE)
public class MsgReceiver {
	private static final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);
	@Autowired
	private OuterClient outerClient;

	@RabbitHandler
	public void process(String msg) {
		logger.error("Receiver  : " + msg);
		String customer_no = "123456";
		// TODO 同步
		Channel channel = Constants.CUSTOMER_CHANNEL_CACHE.get(customer_no);
		if (channel != null) {
			channel.writeAndFlush(msg);
			Constants.CUSTOMER_CHANNEL_CACHE.remove(customer_no);
		} else {
			// TODO 异步
			outerClient.setMsg(msg);
			// outerClient.connect(port, host);
		}
	}
}