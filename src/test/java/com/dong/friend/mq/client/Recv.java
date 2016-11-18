package com.dong.friend.mq.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Recv {
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] argv) throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		System.out.println("[*] Waiting for messages. To exit press CTRL + C");
		channel.basicQos(1);//accept only one unack-ed message at a time(seee below)
		Consumer consumer = new DefaultConsumer(channel){
			public void handleDelivery(String consumerTag,
                    Envelope envelope,
                    AMQP.BasicProperties properties,
                    byte[] body)
                    throws IOException
			{
				String message = new String(body, "UTF-8");
				try{
					doWork(message);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					System.out.println("[x] Done");
//					channel.basicAck(envelope.getDeliveryTag(), false);
				}
				System.out.println("[x] Received" + message);
			}
		};
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);
	}
	
	//根据接收到消息进行逻辑处理
	public static void doWork(String message) throws InterruptedException{
		for(char ch : message.toCharArray()){
			if(ch == '.'){
				Thread.sleep(1000);
			}
		}
	}

}
