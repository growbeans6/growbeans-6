package com.growbeans.cunity.lectureEnrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;

@Controller
public class LectureEnrollmentController {
	
	@Autowired
	private LectureEnrollmentService lecEnService;
	
	
	//수강신청 리스트에 추가
	//세션에서 학번이랑, 강의정보에서 강의 코드 받아와서 데이터에 삽입
	public int insertEnList(LectureEnrollment lecEn) {
		return 0;
	}
	
	//조인해서 가져올꺼임
	public ModelAndView lectureEnList(ModelAndView mv) {
		return mv;
	}
	

}
