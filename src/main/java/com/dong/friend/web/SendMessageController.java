package com.dong.friend.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dong.friend.bean.Receiver;
import com.dong.friend.config.RabbitMQcfg;

@Controller
@RequestMapping("/mq")
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Receiver receiver;

    @RequestMapping("/send1")
    @ResponseBody
    public String sendMessage() {
        rabbitTemplate.convertAndSend(RabbitMQcfg.queueName, "Hello from RabbitMQ!");
        return "OK - count: " + receiver.getLatch();
    }
    
    
    @RequestMapping("/send2")
    @ResponseBody
    public String sendMessage2() {
        rabbitTemplate.convertAndSend(RabbitMQcfg.queueName, "HELLO FROM RABBITMQ!");
        return "OK - count: " + receiver.getLatch();
    }
}
