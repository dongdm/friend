package com.dong.friend.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/**
 * 多数据源配置
 * @author dong
 *
 */
@Configuration
@MapperScan(basePackages = "com.dong.friend.mapper.*")
public class DateSourcePrimaryConfig {

	@Bean(name = "DataSource")
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix="spring.primary.datasource")
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "secondDataSource")
	@Qualifier("secondDataSource")
	@ConfigurationProperties(prefix = "spring.second.datasource")
	public DataSource secondDataSource(){
		return DataSourceBuilder.create().build(); 
	}
	
	@Bean
	@Primary
	public DynamicDataSource dataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
			@Qualifier("secondDataSource") DataSource secondDataSource){
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DatabaseType.primaryDB, primaryDataSource);
		targetDataSources.put(DatabaseType.secondDB, secondDataSource);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
		dataSource.setDefaultTargetDataSource(primaryDataSource);// 默认的datasource设置为myTestDbDataSource
		return dataSource;
	}
	
	
	@Bean
	public SqlSessionFactory primarySqlSessionFactory(
			DynamicDataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*.xml"));
		return bean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager secondTransactionManager(DynamicDataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public SqlSessionTemplate primarySqlSessionTemplate(
			SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
