package com.growbeans.cunity.lecturesyllabus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lecturesyllabus.domain.LectureSyllabus;
import com.growbeans.cunity.lecturesyllabus.service.LectureSyllabusService;

@Controller
public class LectureSyllabusController {
	
	@Autowired
	private LectureSyllabusService lecSylService;
	
	
	@RequestMapping("/lectureDetail")
	public ModelAndView selectOneLecSyl(ModelAndView mv , int lCode, String lName , String lpName) {
		LectureSyllabus lecSyl = lecSylService.selectOneLecSyl(lCode);
		mv.addObject("lecSyl", lecSyl);
		mv.addObject("lName" ,lName);
		mv.addObject("lpName", lpName);
		mv.setViewName("lecture/lectureDetail");
		return mv;
	}
	
	
	

}
