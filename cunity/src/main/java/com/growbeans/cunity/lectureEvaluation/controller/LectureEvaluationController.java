package com.growbeans.cunity.lectureEvaluation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growbeans.cunity.lectureEvaluation.domain.LectureEvaluation;
import com.growbeans.cunity.lectureEvaluation.service.LectureEvaluationService;

@Controller
public class LectureEvaluationController {
	
	@Autowired
	private LectureEvaluationService lecEvaService;
	
	
	public String insertEval(LectureEvaluation lecEval) {
		return null;
	}
	
	@RequestMapping("/lectureEvaluation")
	public String showEval() {
		return "student/stuLecEval";
	}
	


}
