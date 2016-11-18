package com.dong.friend.mq.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {
	
	public static final String EXCHANGE_NAME = "logs";
	
	public static void main(String[] argv) throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		String message = "Hello, Wrold!";
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
		System.out.println("[x] sent " + message);
		channel.close();
		connection.close();
	}

}
