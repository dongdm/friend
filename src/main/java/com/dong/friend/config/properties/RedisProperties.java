package com.dong.friend.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * com.redis.configuration.properties
 * Created by mimiczo on 2016.03.03
 */
@Component
public class RedisProperties {
	@Value("${spring.redis.host}")
    private String hostname;
	@Value("${spring.redis.port}")
    private String port;
	
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	
	
}
