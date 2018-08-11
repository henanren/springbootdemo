package com.laomn.mq.receiver;

import io.netty.channel.Channel;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.laomn.utils.Constants;

@Component
@RabbitListener(queues = Constants.RECEIVE_QUEUE)
public class MsgReceiver {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("Receiver  : " + msg);
		String key = "";
		String body = "";
		// TODO
		Channel channel = Constants.CUSTOMER_CHANNEL_CACHE.get(key);
		if (channel != null) {
			channel.writeAndFlush(body);
		}

	}
}