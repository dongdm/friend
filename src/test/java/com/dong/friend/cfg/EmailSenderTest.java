package com.dong.friend.cfg;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dong.friend.ApplicationTest;
import com.dong.friend.config.EmailSender;

public class EmailSenderTest extends ApplicationTest{

	private static final Logger LOG = LoggerFactory.getLogger(EmailSenderTest.class);
	@Autowired
	private EmailSender emailSender;
	
	@Test
	public void sender() throws InterruptedException{
		String to = "dongdm@c3fund.com";
		String subject = "Test subject";
		String content = "Hello Spring Boot Eamil.";
		boolean result = emailSender.sender(to, subject, content);
		LOG.info("send email-----------------------------------------------:" + result);
		
//		Thread.currentThread().sleep(Integer.MAX_VALUE);;
	}
	
}
