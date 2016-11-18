package com.dong.friend.config;

/**
 * 作用：
 * 保存一个线程安全的DatabaseType容器
 * @author dong
 *
 */
public class DatabaseContextHolder {
	
	private static final ThreadLocal<DatabaseType> contextHoler = new ThreadLocal<>();
	
	public static void setDatabaseType(DatabaseType type){
		contextHoler.set(type);
	}

	public static DatabaseType getDatabaseType(){
		return contextHoler.get();
	}
	
}
