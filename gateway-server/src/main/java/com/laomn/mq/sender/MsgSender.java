package com.laomn.mq.sender;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laomn.utils.Constants;

@Component
public class MsgSender {
	private static final Logger logger = LoggerFactory.getLogger(MsgSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String msg) {
		if (StringUtils.isNotBlank(msg)) {
			logger.info("send: " + msg);
			this.rabbitTemplate.convertAndSend(Constants.QUEUE, msg);
		}

	}
}
