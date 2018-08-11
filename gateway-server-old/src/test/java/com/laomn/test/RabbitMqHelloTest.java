//package com.laomn.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.laomn.Application;
//import com.laomn.mq.sender.MsgSender;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class RabbitMqHelloTest {
//
//	@Autowired
//	private MsgSender helloSender;
//
//	@Test
//	public void hello() throws Exception {
//		helloSender.send("1111111111");
//	}
//
// }