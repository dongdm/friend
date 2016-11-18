package com.dong.friend.service;

import java.util.List;

import com.dong.friend.bean.ModuleInfo;

public interface ModuleService {
	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	List<ModuleInfo> findModuleByUserId(int userId);
}
