package com.planner.planner.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
		"com.planner.planner.user.mapper", 
		"com.planner.planner.todo.mapper", 
		"com.planner.planner.batch.mapper",
		"com.planner.planner.admin.mapper"})
public class MyBatisConfig {
}