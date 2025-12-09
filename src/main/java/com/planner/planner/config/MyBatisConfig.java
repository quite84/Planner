package com.planner.planner.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.planner.planner.user.mapper")
public class MyBatisConfig {
}