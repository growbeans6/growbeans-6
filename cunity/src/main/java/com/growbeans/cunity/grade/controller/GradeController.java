/*package com.growbeans.cunity.grade.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.grade.service.GradeService;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;

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
		@RequestMapping("/insertGrade")
		public String insertGrade(String sRate,HttpServletRequest request,int sNo,int lCode) {
			LectureEnrollment lectureenroll = new LectureEnrollment();
			lectureenroll.setlCode(lCode);
			lectureenroll.setsRate(sRate);
			lectureenroll.setsNo(sNo);
			int result = gService.insertGrade(lectureenroll);
			if(result > 0) {
				return "success";
			} else {
				return "fail";
			}
		}
		@RequestMapping("/stuGrade")
		public String showGrade() {
			return "student/stuGrade";
		}
		
}
*/