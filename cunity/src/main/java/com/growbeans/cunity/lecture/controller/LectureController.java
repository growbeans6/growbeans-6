package com.growbeans.cunity.lecture.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lecService;
	
	//전체리스트 띄워서 수강신청 리스트에서 사용
	@RequestMapping("/lectureList")
	public ModelAndView allLecture(ModelAndView mv) {
		List<Lecture> lectureList = lecService.allLectureList();
		mv.addObject("lectureList",lectureList);
		mv.setViewName("lecture/lectureList");
		return mv;
	}

	
	//강의 등록
	@RequestMapping("/lectureInsert")
	public ModelAndView insertLecture(ModelAndView mv) {
		mv.setViewName("professor/lectureInsert");
		return mv;
	}
	
	//강의 삭제
	public String deleteLecture(int lCode) {
		return null;
	}
	

	// 강의 내 수강생 목록 조회
	@RequestMapping("/lStudentList")
	public ModelAndView studentList(ModelAndView mv) {
		mv.setViewName("professor/studentList1");
		return mv;
	}
	
	// 강의 시간표
	@RequestMapping("/lectureTime")
	public ModelAndView lectureTime(ModelAndView mv) {
		mv.setViewName("professor/lectureTime");
		return mv;
	}

}
