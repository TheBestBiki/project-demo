package com.biki.project.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置Durid的参数类，用于封装参数，给DuridDataSourceConfig类调用
 * @ConfigurationProperties 注解实际就是去读取yml里的参数信息
 */
@ConfigurationProperties(prefix="spring.datasource")
@Component
public class DuridConfig {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private int initSize;
	private int maxActive;
	private int minIdle;
	private long maxWait;
	private boolean testOnReturn;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitSize() {
		return initSize;
	}

	public void setInitSize(int initSize) {
		this.initSize = initSize;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public long getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(long maxWait) {
		this.maxWait = maxWait;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	@Override
	public String toString() {
		return "DuridConfig{" +
				"driverClassName='" + driverClassName + '\'' +
				", url='" + url + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", initSize=" + initSize +
				", maxActive=" + maxActive +
				", minIdle=" + minIdle +
				", maxWait=" + maxWait +
				", testOnReturn=" + testOnReturn +
				'}';
	}
}
