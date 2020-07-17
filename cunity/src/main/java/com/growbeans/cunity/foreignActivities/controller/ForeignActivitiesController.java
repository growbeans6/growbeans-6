package com.growbeans.cunity.foreignActivities.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.foreignActivities.domain.ForeignActivities;
import com.growbeans.cunity.foreignActivities.service.ForeignActivitiesService;


@Controller
public class ForeignActivitiesController {
	
	@Autowired
	private ForeignActivitiesService ForeignService;
	
	
	//대외활동 화면으로 넘기기
	/*@RequestMapping("/selectActInfoView")
    public String selectActInfoView() {
       return "tbl_Activity";
    }*/
	
	
	//대외활동 조회
	@RequestMapping(value="/selectActInfoView", method=RequestMethod.GET)
	public ModelAndView foreignInfo(ModelAndView mv, int sNo) {
		ArrayList<ForeignActivities> actinfo = ForeignService.foreignInfo(sNo);
		System.out.println(sNo);
		System.out.println(actinfo);
		if (actinfo != null) {
			mv.addObject("actinfo",actinfo);
			mv.setViewName("tbl_Activity");
		} else {
			mv.addObject("msg", "대외활동 조회 실패");
			mv.setViewName("home");
		}
		return mv;
	}
	
	
	//대외활동 삽입
	public int insertForeignAct(ForeignActivities fAct) {
		return 0;
	}


}
