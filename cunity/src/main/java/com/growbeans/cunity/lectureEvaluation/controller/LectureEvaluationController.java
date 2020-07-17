package com.growbeans.cunity.lectureEvaluation.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lectureEvaluation.domain.LectureEvaluation;
import com.growbeans.cunity.lectureEvaluation.service.LectureEvaluationService;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class LectureEvaluationController {
	
	@Autowired
	private LectureEvaluationService lecEvaService;
	
	@RequestMapping(value="/insertEval", method=RequestMethod.POST)
	public String insertEval(LectureEvaluation lecEval, HttpSession session) {
		Student student = (Student)session.getAttribute("loginStudent");
		lecEval.setsNo(student.getsNo());
		lecEvaService.insertEval(lecEval);
		System.out.println(lecEval.geteContent());
		System.out.println(lecEval.geteRate());
		return "redirect:/stuGrade";
	}
	
	@RequestMapping("/lectureEvaluation")
	public ModelAndView showEval(ModelAndView mv ,int lCode, String lpName,String lName) {
		mv.addObject("lCode" ,lCode);
		mv.addObject("lpName" ,lpName);
		mv.addObject("lName" ,lName);
		mv.setViewName("student/stuLecEval");
		return mv;
	}
	


}
