package com.laomn.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述: 接收者
 *
 * @author: yanpenglei
 * @create: 2017/10/23 14:15
 */
//@Component
//@RabbitListener(queues = "topic.message")
//@RabbitListener(queues = "gyl.activateQueue")
public class TopicReceiver1 {

	@RabbitHandler
	public void process(String message) {
		System.out.println("接收者  1 :" + message);
	}

}
