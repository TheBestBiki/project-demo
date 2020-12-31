package com.biki.project.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * springboot mybatis整合：https://my.oschina.net/bianxin/blog/1602958
 * 配置SqlSessionFactory 参考：https://my.oschina.net/bianxin/blog/1602958
 */
@Configuration
@MapperScan(basePackages = {"com.biki.project.mapper"})
public class DuridDataSourceConfig {
	
	@Autowired
	private DuridConfig duridConfig;

	/**
	 * 声明扫描的包
	 * @return
	 */
	/*@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.biki.project.mapper");
		return mapperScannerConfigurer;
		//mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryMysql");
		//mapperScannerConfigurer.setBasePackage("com.dji.pi.mis.mapper,com.dji.pi.od.mapper");
	}*/

	@Bean("mysqlDataSource")
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

	/**
	 * 声明会话管理器 -- 管理事务
	 * @param ds
	 * @return
	 */
	@Bean("myTransactionManager")
	public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource ds) {
		DataSourceTransactionManager t = new DataSourceTransactionManager();
		t.setDataSource(ds);
		return t;
	}

//	@Bean("sqlSessionFactoryMysql")
//	public SqlSessionFactoryBean getSqlSessionFactoryMysql(@Qualifier("mysqlDataSource") DataSource datasource) throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(datasource);
//		sqlSessionFactoryBean.setTypeAliasesPackage("com.dji.pi.mis.bean.model");
//		sqlSessionFactoryBean.setVfs(SpringBootVFS.class); // 设置SpringBootVFS
//		List<Resource> resources = new ArrayList<>();
//		Collections.addAll(resources, new PathMatchingResourcePatternResolver().getResources("classpath*:com/dji/pi/mis/bean/mapper/*Mapper.xml"));
//		Collections.addAll(resources, new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/**/*Mapper.xml"));
//		Resource[] arrayResources = new Resource[resources.size()];
//		resources.toArray(arrayResources);
//		sqlSessionFactoryBean.setMapperLocations(arrayResources);
//		return sqlSessionFactoryBean;
//	}

//	@Bean("sqlSessionFactoryOracle")
//	public SqlSessionFactoryBean getSqlSessionFactoryOracle(@Qualifier("oracleDataSource") DataSource datasource) throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(datasource);
//		sqlSessionFactoryBean.setTypeAliasesPackage("com.dji.pi.mis.bean.oracle");
//		sqlSessionFactoryBean.setVfs(SpringBootVFS.class); // 设置SpringBootVFS
//		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/dji/pi/mis/bean/oracle/mapper/*Mapper.xml"));
//		sqlSessionFactoryBean.setPlugins(new Interceptor[] {new SqlStatementInterceptor()});
//		return sqlSessionFactoryBean;
//	}
	
}
