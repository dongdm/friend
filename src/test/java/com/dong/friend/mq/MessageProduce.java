package com.dong.friend.mq;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.dong.friend.ApplicationTest;
import com.dong.friend.bean.Receiver;
import com.dong.friend.config.RabbitMQcfg;

public class MessageProduce extends ApplicationTest{
	
	@Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;
	
	@Test
	@Ignore
    public void produceSender() throws Exception {
        rabbitTemplate.convertAndSend(RabbitMQcfg.queueName, "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
	
	@Test
	public void propertyTest(){
		
	}

}
