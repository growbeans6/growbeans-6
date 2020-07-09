package com.growbeans.cunity.professor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.professor.service.ProfessorService;
import com.growbeans.cunity.student.domain.Student;

@SessionAttributes({"loginprof"})
@Controller
public class ProfessorController {
   
   @Autowired
   private ProfessorService pService; 
   
   // 교수 정보 //세션에서 교번을 가져온다.
   @RequestMapping("/profInfo")
   public ModelAndView professorInfo(ModelAndView mv) {
	   mv.setViewName("common/loginPage");
      return mv;
   }
   
   // 교수 정보 수정
   @RequestMapping("/profInfoUpdate")
   public ModelAndView updateprofessorInfo(ModelAndView mv, Professor prof) {
	   int result = pService.updateProfessorInfo(prof);
	   if(result > 0 ) {
		   mv.addObject("loginprof", prof);
		   mv.setViewName("professor/profInfoUpdate");
	   } else {
		   mv.setViewName("common/loginPage");
	   }
      return mv;
   }
   
   // 지도학생 리스트조회
   @RequestMapping("/studentList")
   public ModelAndView guidanceList(ModelAndView mv) {
	   mv.setViewName("tbl_LeadStudent");
      return mv;
   }
   
   
   // 교수 로그인
   @RequestMapping(value="/profLogin", method=RequestMethod.POST)
   public ModelAndView professorLogin(ModelAndView mv, Professor prof) {
	   Professor loginprof = pService.professorLogin(prof);
	   
	   if(loginprof != null) {
		   int professornum = 0;
		   mv.addObject("judge", professornum);
		   System.out.println(professornum);
		   mv.addObject("loginprof", loginprof);
		   System.out.println(loginprof);
		   mv.setViewName("home");
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


