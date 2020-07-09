package com.growbeans.cunity.professor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.professor.service.ProfessorService;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class ProfessorController {
   
   @Autowired
   private ProfessorService pService; 
   
   // 교수 정보 //세션에서 교번을 가져온다.
   @RequestMapping("/profInfo")
   public ModelAndView professorInfo(ModelAndView mv) {
	   mv.setViewName("professor/profInfo");
      return mv;
   }
   
   // 교수 정보 수정
   @RequestMapping("/profInfoUpdate")
   public ModelAndView updateprofessorInfo(ModelAndView mv) {
	   mv.setViewName("professor/profInfoUpdate");
      return mv;
   }
   
   // 지도학생 리스트조회
   @RequestMapping("/studentList")
   public ModelAndView guidanceList(ModelAndView mv) {
	   mv.setViewName("tbl_LeadStudent");
      return mv;
   }
}


