package com.laomn.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.laomn.utils.Constants;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue sendQueue() {
		return new Queue(Constants.SEND_QUEUE);
	}

	@Bean
	public Queue receiveQueue() {
		return new Queue(Constants.RECEIVE_QUEUE);
	}

	// @Bean
	// public Queue queueMessages() {
	// return new Queue(RabbitTopicConfig.MESSAGES);
	// }
	//
	// @Bean
	// public Queue queueYmq() {
	// return new Queue(RabbitTopicConfig.YMQ);
	// }

	/**
	 * 交换机(Exchange) 描述：接收消息并且转发到绑定的队列，交换机不存储消息
	 */
	// @Bean
	// TopicExchange sendExchange() {
	// return new TopicExchange(Constants.sendExchange);
	// }

	// @Bean
	// TopicExchange receiveExchange() {
	// return new TopicExchange(Constants.receiveExchange);
	// }

	// 綁定队列 queueMessages() 到 topicExchange 交换机,路由键只接受完全匹配 topic.message
	// 的队列接受者可以收到消息
	// @Bean
	// Binding bindingSendExchange(Queue sendQueue, TopicExchange sendExchange)
	// {
	// return
	// BindingBuilder.bind(sendQueue).to(sendExchange).with(Constants.SEND_QUEUE);
	// }

	// @Bean
	// Binding bindingReceiveExchange(Queue receiveQueue, TopicExchange
	// receiveExchange) {
	// return
	// BindingBuilder.bind(receiveQueue).to(receiveExchange).with(Constants.RECEIVE_QUEUE);
	// }

	// 綁定队列 queueMessages() 到 topicExchange 交换机,路由键只要是以 topic.message
	// 开头的队列接受者可以收到消息
	// @Bean
	// Binding bindingExchangeMessages(Queue queueMessages, TopicExchange
	// topicExchange) {
	// return
	// BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.message.#");
	// }

	// 綁定队列 queueYmq() 到 topicExchange 交换机,路由键只要是以 topic 开头的队列接受者可以收到消息
	// @Bean
	// Binding bindingExchangeYmq(Queue queueYmq, TopicExchange topicExchange) {
	// return BindingBuilder.bind(queueYmq).to(topicExchange).with("topic.#");
	// }

}
