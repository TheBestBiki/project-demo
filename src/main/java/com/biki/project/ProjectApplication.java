package com.biki.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.biki.project.mapper"})
public class ProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProjectApplication.class);
	}

}
