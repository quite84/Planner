package com.planner.planner.admin.service;

import com.planner.planner.admin.dto.DashboardDTO;

public interface AdminService {
	
	/* 2025.12.18 이후 관리자 사이트에서 다루는 부분을 개발 회원수, 신규 가입수, 전체 투두 리스트 내역 확인, 배치 작업 내역 확인 , 배치 관리 테이블 생성/업데이트 로직 생성 필요 */
	
	public DashboardDTO getDashboardData();
}
