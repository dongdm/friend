package com.dong.friend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dong.friend.bean.Temp;
import com.dong.friend.config.DatabaseContextHolder;
import com.dong.friend.config.DatabaseType;
import com.dong.friend.mapper.second.TempMapper;
import com.dong.friend.service.TempService;
/**
 * 多数据源查询测试
 * @author dong
 *
 */
@Service
public class TempServiceImpl implements TempService{
	
	@Autowired
	private TempMapper tempMapper;
	
	public TempServiceImpl(){
		//指定数据源
		DatabaseContextHolder.setDatabaseType(DatabaseType.secondDB);
	}

	@Override
	public List<Temp> getAll() {
		return tempMapper.getAll();
	}

}
