package com.dong.friend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dong.friend.bean.ModuleInfo;
import com.dong.friend.config.DatabaseContextHolder;
import com.dong.friend.config.DatabaseType;
import com.dong.friend.mapper.primary.ModuleMapper;
import com.dong.friend.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleMapper moduleMapper;
	
	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	public List<ModuleInfo> findModuleByUserId(int userId) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.primaryDB);
		return moduleMapper.findModuleByUserId(userId);
	}
}
