package com.growbeans.cunity.lecturesyllabus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.growbeans.cunity.lecturesyllabus.domain.LectureSyllabus;
import com.growbeans.cunity.lecturesyllabus.service.LectureSyllabusService;

@Controller
public class LectureSyllabusController {
	
	@Autowired
	private LectureSyllabusService lecSylService;
	
	public LectureSyllabus selectOneLecSyl(int lCode) {
		lecSylService.selectOneLecSyl(lCode);
		return null;
	}

}
