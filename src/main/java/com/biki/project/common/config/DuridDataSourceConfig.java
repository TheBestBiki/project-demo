package com.biki.project.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DuridDataSourceConfig {
	
	@Autowired
	private DuridConfig duridConfig;
	
	@Bean
	public DataSource createDuridDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(duridConfig.getDriverClassName());
		ds.setUrl(duridConfig.getUrl());
		ds.setUsername(duridConfig.getUsername());
		ds.setPassword(duridConfig.getPassword());
		ds.setInitialSize(duridConfig.getInitSize());
		ds.setMaxActive(duridConfig.getMaxActive());
		ds.setMinIdle(duridConfig.getMinIdle());
		ds.setMaxWait(duridConfig.getMaxWait());
		ds.setTestOnReturn(duridConfig.isTestOnReturn());
		return ds;
	}
	
	
}
