package com.growbeans.cunity.foreignActivities.service;


import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.foreignActivities.domain.ForeignActivities;

public interface ForeignActivitiesService {
	
	/**
	 * 학생마다 대외활동 정보 조회
	 * 
	 * @param sNo
	 * @return
	 */
	
	public ArrayList<ForeignActivities> foreignInfo(int sNo);
	
	/**
	 * 대외 활동 정보 삭제
	 * @param fAct
	 * @return
	 */
	
	public int insertForeignAct(ForeignActivities fAct);
	

}
