package com.dong.friend.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 继承AbstractRoutingDataSource，提供动态数据库切换
 * @author dong
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DatabaseContextHolder.getDatabaseType();
	}

}
