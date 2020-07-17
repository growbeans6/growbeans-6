package com.growbeans.cunity.lecture.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;
import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.student.domain.Student;

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
	
	@RequestMapping("/lectureInsertPage")
	public ModelAndView insertLecturePage(ModelAndView mv,HttpSession session) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		mv.addObject("professor", professor);
		mv.setViewName("professor/lectureInsert");
		return mv;
	}

	
	//강의 등록
	@RequestMapping(value="/lectureInsert", method=RequestMethod.POST)
	public String insertLecture(HttpSession session, Lecture lecture) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		lecture.setpNo(professor.getpNo());
		System.out.println(lecture.getpNo());
		
		lecService.insertLecture(lecture);

		return "redirect:/prolectureList";
	}
	
	//강의 삭제
	@RequestMapping("/deleteLecture")
	public String deleteLecture(int lCode) {
		lecService.deleteLecture(lCode);
		return "redirect:/prolectureList";
	}
	

	// 강의 내 수강생 목록 조회
	@RequestMapping("/lStudentList")
	public ModelAndView lecStudentList(ModelAndView mv, int lCode) {
		List<Student> lecStudentList = lecService.lecStudentList(lCode);
		mv.addObject("lCode",lCode);
		mv.addObject("lecStudentList", lecStudentList);
		mv.setViewName("professor/studentList1");
		return mv;
	}
	
	// 강의 내 수강생 목록 조회
	@RequestMapping("/prolectureList")
	public ModelAndView prolectureList(ModelAndView mv, HttpSession session) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		int pNo = professor.getpNo();
		
		List<Lecture> proLectureList = lecService.proLectureList(pNo);
		mv.addObject("proLectureList", proLectureList);
		mv.setViewName("professor/lectureList");
		return mv;
	}
	
	// 강의 시간표
	@RequestMapping("/lectureTime")
	public ModelAndView lectureTime(ModelAndView mv) {
		mv.setViewName("professor/lectureTime");
		return mv;
	}

}
