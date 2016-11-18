package com.dong.friend;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AppBeanTest extends ApplicationTest{
	
	private final static Logger LOG = LoggerFactory.getLogger(AppBeanTest.class);

	@Autowired
	private ApplicationContext app;
	
	@Test
	public void getBeanNames(){
		for(String beanName : app.getBeanDefinitionNames()){
			LOG.info(beanName);
		}
		try {
			Thread.currentThread().sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
