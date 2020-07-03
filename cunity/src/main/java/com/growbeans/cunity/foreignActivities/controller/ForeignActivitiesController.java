package com.growbeans.cunity.foreignActivities.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.foreignActivities.domain.ForeignActivities;
import com.growbeans.cunity.foreignActivities.service.ForeignActivitiesService;

@Controller
public class ForeignActivitiesController {
	
	@Autowired
	private ForeignActivitiesService ForeignService;
	
	
	//대외활동 조회
	public ModelAndView foreignInfo(ModelAndView mv, int sNo) {
		return mv;
		
	}
	//대외활동 삽입
	public int insertForeignAct(ForeignActivities fAct) {
		return 0;
	}


}
