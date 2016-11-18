package com.dong.friend.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.dong.friend.ApplicationTest;
import com.dong.friend.bean.UserInfo;
import com.dong.friend.mapper.primary.UserMapper;

public class UserServiceImplTest extends ApplicationTest{
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void findByAccount(){
		String account = "admin";
		UserInfo into = userMapper.findByAccount(account);
		Assert.notNull(into);
		Assert.isTrue(into.getId() == 1);
		Assert.isTrue(into.getId() == 3);
	}

}
