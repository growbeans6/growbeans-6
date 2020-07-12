package com.growbeans.cunity.lectureEnrollment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class LectureEnrollmentController {
	
	@Autowired
	private LectureEnrollmentService lecEnService;
	
	
	//수강신청 리스트에 추가
	//세션에서 학번이랑, 강의정보에서 강의 코드 받아와서 데이터에 삽입
	@RequestMapping("/insertEnList")
	public String insertEnList(LectureEnrollment lecEn,HttpServletRequest request,HttpSession session) {
		int lcode = Integer.parseInt(request.getParameter("lcode"));
		Student student = (Student)session.getAttribute("loginStudent");
		lecEn.setsNo(student.getsNo());
		lecEn.setlCode(lcode);
		int result = lecEnService.insertEnList(lecEn);
		if(result > 0){return "redirect:/lectureList";}
		else { return null;}
		
	}
	
	//조인해서 가져올꺼임
	@RequestMapping("/lectureEnrollList")
	public ModelAndView lectureEnList(ModelAndView mv,HttpSession session) {
		Student student = (Student)session.getAttribute("loginStudent");
		int sNo = student.getsNo();
		List<Lecture> lectureEnList = lecEnService.lectureEnList(sNo);
		mv.addObject("lectureEnList",lectureEnList);
		mv.setViewName("lecture/lectureEnrollList");
		return mv;
	}
	
	@RequestMapping("/deleteEnList")
	public String deleteEnList(HttpServletRequest request) {
		int lcode = Integer.parseInt(request.getParameter("lcode"));
		int result = lecEnService.deleteEnList(lcode);
		
		if (result>0) {
			return "redirect:/lectureEnrollList";
		}
		else {
			return "redirect:/lectureList";
		}
		
	}
	
	
	@RequestMapping("/schedule")
	public String showSchedule() {
		return "lecture/lectureSchedule";
	}
	
	

}
