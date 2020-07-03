package com.growbeans.cunity.lecture.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lecService;
	
	//전체리스트 띄워서 수강신청 리스트에서 사용
	public ModelAndView allLecture(ModelAndView mv) {
		return mv;
	}
	
	//강의 등록
	public String insertLecture(Lecture lecture) {
		return null;
	}
	
	//강의 삭제
	public String deleteLecture(int lCode) {
		return null;
	}
	


}
