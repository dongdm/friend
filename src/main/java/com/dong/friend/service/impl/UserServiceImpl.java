package com.dong.friend.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dong.friend.bean.ModuleInfo;
import com.dong.friend.bean.UserInfo;
import com.dong.friend.config.DatabaseContextHolder;
import com.dong.friend.config.DatabaseType;
import com.dong.friend.mapper.primary.UserMapper;
import com.dong.friend.service.ModuleService;
import com.dong.friend.service.UserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 多数据源
 * @author dong
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ModuleService moduleService;
	
	public UserServiceImpl(){
		//指定数据源，该数据源为默认数据源也可以不指定
		DatabaseContextHolder.setDatabaseType(DatabaseType.primaryDB);
	}


	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	public UserInfo findByAccount(String account) {
		return userMapper.findByAccount(account);
	}

	/**
	 * 获取资源集合
	 * @param account
	 * @return
	 */
	public Set<String> findPermissions(String account) {
		Set<String> set = Sets.newHashSet();
		UserInfo user = findByAccount(account);
		List<ModuleInfo>modules = moduleService.findModuleByUserId(user.getId());
		
		for(ModuleInfo info: modules) {
			set.add(info.getModuleKey());
		}
		return set;
	}

	/**
	 * 获取URL权限
	 * @param account
	 * @return
	 */
	public List<String> findPermissionUrl(String account) {
		List<String> list = Lists.newArrayList();
		UserInfo user = findByAccount(account);
		List<ModuleInfo>modules = moduleService.findModuleByUserId(user.getId());
		
		for(ModuleInfo info: modules) {
			if(info.getModuleType() == ModuleInfo.URL_TYPE) {
				list.add(info.getModulePath());
			}
		}
		return list;
	}
}