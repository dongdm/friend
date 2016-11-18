package com.dong.friend.mapper.second;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dong.friend.bean.Temp;

public interface TempMapper {
	
	@Select("select * from t_temp")
	List<Temp> getAll();

}
