package com.growbeans.cunity.grade.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.grade.service.GradeService;

@Controller
public class GradeController {
	
	@Autowired
	private GradeService gService;
	
		//성적 조회
		@RequestMapping("/profGrade")
		public ModelAndView selectGrade(ModelAndView mv){
			mv.setViewName("professor/Grade");
			return mv;
		}
		
		//성적 삽입
		public String insertGrade() {
			return null;
		}

}
