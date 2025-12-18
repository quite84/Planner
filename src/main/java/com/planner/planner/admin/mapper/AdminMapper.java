package com.planner.planner.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
	public int getTotalUserCount();
	public int getTodayUserCount();
	public int getTotalTodoCount();
	public int getTodayTodoCount();
}
