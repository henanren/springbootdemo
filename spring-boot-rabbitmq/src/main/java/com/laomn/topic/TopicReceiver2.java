package com.laomn.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/**
 * 描述: 接收者
 *
 * @author: yanpenglei
 * @create: 2017/10/23 14:15
 */
// @Component
// @RabbitListener(queues = "topic.message.s")
public class TopicReceiver2 {

	@RabbitHandler
	public void process(String message) {
		System.out.println("接收者 TopicReceiver2," + message);
	}

}
