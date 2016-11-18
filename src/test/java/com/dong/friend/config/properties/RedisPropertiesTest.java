package com.dong.friend.config.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisPropertiesTest {
	
	
	@Autowired
	private RedisProperties redisProperties;
	
	@Test
	public void redisPro(){
		
		System.out.println("redisProperties:" + redisProperties.getHostname());
		System.out.println("redisProperties:" + redisProperties.getPort());
	}

}
