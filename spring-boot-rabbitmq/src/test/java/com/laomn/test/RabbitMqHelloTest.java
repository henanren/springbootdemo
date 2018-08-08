package com.laomn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.laomn.config.HelloSender;
import com.laomn.run.Startup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class RabbitMqHelloTest {
 
    @Autowired
    private HelloSender helloSender;
 
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
 
}