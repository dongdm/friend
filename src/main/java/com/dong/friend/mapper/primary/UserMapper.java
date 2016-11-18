package com.dong.friend.mapper.primary;

import org.apache.ibatis.annotations.Select;

import com.dong.friend.bean.UserInfo;

public interface UserMapper {

	@Select("select * from t_user where account=#{account}")
	UserInfo findByAccount(String account);
}
