package com.dong.friend.bean;

import java.io.Serializable;

/**
 * com.redis.domain
 * Created by mimiczo on 2016.03.03
 */

public class Hello implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
    private String message;

    public Hello() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
