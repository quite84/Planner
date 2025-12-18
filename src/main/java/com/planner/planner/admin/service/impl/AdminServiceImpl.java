package com.planner.planner.admin.service.impl;

import org.springframework.stereotype.Service;

import com.planner.planner.admin.dto.DashboardDTO;
import com.planner.planner.admin.mapper.AdminMapper;
import com.planner.planner.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final AdminMapper adminMapper;
	
	public AdminServiceImpl(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public DashboardDTO getDashboardData() {
		return DashboardDTO.builder()
				.totalUserCount(adminMapper.getTotalUserCount())
				.todayUserCount(adminMapper.getTodayUserCount())
				.totalTodoCount(adminMapper.getTotalTodoCount())
				.todayTodoCount(adminMapper.getTodayTodoCount())
				.build();
	}

}

