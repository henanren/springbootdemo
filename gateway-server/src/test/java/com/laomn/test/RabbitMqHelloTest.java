package com.laomn.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.laomn.mq.sender.MsgSender;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class RabbitMqHelloTest {

	@Autowired
	private MsgSender helloSender;

	// @Test
	public void hello() throws Exception {
		helloSender.send("1111111111");
	}

}