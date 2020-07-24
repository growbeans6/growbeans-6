package com.growbeans.cunity.professor.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;
import com.growbeans.cunity.departmentNotice.service.DepartmentNoticeService;
import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.professor.service.ProfessorService;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.service.StudentService;


@SessionAttributes({"loginprof","judge"})

@Controller
public class ProfessorController {
   
   @Autowired
   private ProfessorService pService; 
   @Autowired
   private StudentService studentService;
   @Autowired
   private LectureService lecService;
   @Autowired
   private LectureEnrollmentService lecEnService;
   @Autowired
   private DepartmentNoticeService dService;
   
   // 교수 정보 //세션에서 교번을 가져온다.
   @RequestMapping("/profInfo")
   public ModelAndView professorInfo(ModelAndView mv) {
	   mv.setViewName("professor/profInfo");
      return mv;
   }
   
   // 교수 정보 수정
   @RequestMapping(value="/profInfoUpdate", method=RequestMethod.POST)
   public String updateprofessorInfo(Model model, Professor prof, RedirectAttributes rd) {
	   int result = pService.updateProfessorInfo(prof);
	   if(result > 0 ) {
		   model.addAttribute("loginprof", prof);
		   rd.addFlashAttribute("msg", "정보수정 성공");
		   return "redirect:/profInfo";
	   } else {
		   model.addAttribute("msg", "정보 수정 실패");
		   return "home";
	   }
   }
   
   // 지도학생 리스트조회
   @RequestMapping(value="/studentList")
   public ModelAndView guidanceList(ModelAndView mv, HttpSession session) {
	   Professor professor = (Professor)session.getAttribute("loginprof");
	   int pNo = professor.getpNo();
	   ArrayList<Student> gdList = pService.guidanceList(pNo);
	   
	   if (!gdList.isEmpty()) {
		   mv.addObject("gdList", gdList);
		   mv.setViewName("tbl_LeadStudent");
	   } else {
		   mv.setViewName("home");
	   }
      return mv;
   }
   
   // 학생상세조회
   @RequestMapping(value="/studentDtlInfo")
   public ModelAndView studentDtlInfo(Student student, ModelAndView mv) {
	   Student studentDtlInfo = studentService.loginStudent(student);
	   
	   if (studentDtlInfo != null) {
		   mv.addObject("loginStudent", studentDtlInfo);
		   mv.setViewName("student/studentInfo");
	   } else {
		   mv.setViewName("home");
	   }
      return mv;
   }
   
   
   // 교수 로그인
   @RequestMapping(value="/profLogin", method=RequestMethod.POST)
   public ModelAndView professorLogin(ModelAndView mv, Professor prof) {
	   Professor loginprof = pService.professorLogin(prof);
	   ArrayList<DepartmentNotice> dnlist = dService.noticeList();
	   if(loginprof != null) {
		   int professornum = 0;
		   int pNo = prof.getpNo();
		   List<Lecture> proLecList = lecService.proLectureList(pNo);
		   Timetable table = lecEnService.showProList(pNo);
		   mv.addObject("judge", professornum);
		   mv.addObject("loginprof", loginprof);
		   mv.addObject("proLecList", proLecList);
		   mv.addObject("timetable", table);
		   mv.addObject("dnlist", dnlist);
		   mv.setViewName("professorhome");
	   } else {
		   mv.setViewName("common/loginPage");
	   } 
	   return mv;
   }
   
   // 교수 로그아웃
   @RequestMapping("/profLogout")
   public String professorLogout(SessionStatus status) {
	   status.setComplete();
	   return "common/loginPage";
   }
   
   
}


