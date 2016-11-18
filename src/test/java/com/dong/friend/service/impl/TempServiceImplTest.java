package com.dong.friend.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.dong.friend.ApplicationTest;
import com.dong.friend.bean.Temp;
import com.dong.friend.service.TempService;

public class TempServiceImplTest extends ApplicationTest{
	
	@Autowired
	private TempService tempService;
	
	@Test
	public void getAll(){
		List<Temp> tempList = tempService.getAll();
		Assert.notNull(tempList);
		Assert.isTrue(tempList.size() == 1);
	}

}
