package com.planner.planner.admin.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DashboardDTO {
	private int totalUserCount;
	private int todayUserCount;
	private int totalTodoCount;
	private int todayTodoCount;

	public DashboardDTO(int totalUserCount, int todayUserCount, int totalTodoCount, int todayTodoCount) {
		this.totalUserCount = totalUserCount;
		this.todayUserCount = todayUserCount;
		this.totalTodoCount = totalTodoCount;
		this.todayTodoCount = todayTodoCount;
	}
}
