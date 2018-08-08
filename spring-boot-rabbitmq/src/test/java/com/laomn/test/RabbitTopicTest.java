package com.laomn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.laomn.run.Startup;

/**
 * 描述: 配置转发消息模式队列
 *
 * @author: yanpenglei
 * @create: 2017/10/25 1:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
// @SpringBootTest
public class RabbitTopicTest {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Test
	public void sendMessageTest() {

		String context = "此消息在 - ";
		    String MESSAGE1 = "gyl.activateQueue";
//		String routeKey = "topic.message";

		// String exchange = "topicExchange";

		// context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" +
		// context;

		for (int i = 0; i < 1; i++) {
			String str = context + i;
			// System.out.println("sendMessageTest : " + str);
//			 this.rabbitTemplate.convertAndSend("gyl.activateExchange", "gyl.#", context + i);
			this.rabbitTemplate.convertAndSend(MESSAGE1, str);
		}

	}

	// @Test
	public void sendMessagesTest() {

		String context = "此消息在，配置转发消息模式队列下，有  TopicReceiver2 TopicReceiver3 可以收到";

		String routeKey = "topic.message.s";

		String exchange = "topicExchange";

		context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

		System.out.println("sendMessagesTest : " + context);

		this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
	}

	// @Test
	public void sendYmqTest() {

		String context = "此消息在，配置转发消息模式队列下，有 TopicReceiver3 可以收到";

		String routeKey = "topic.ymq";

		String exchange = "topicExchange";

		context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

		System.out.println("sendYmqTest : " + context);

		this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
	}

}
