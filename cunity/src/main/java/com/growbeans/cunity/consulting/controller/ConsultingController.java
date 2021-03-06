package com.growbeans.cunity.consulting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.consulting.domain.Consulting;
import com.growbeans.cunity.consulting.service.ConsultingService;
import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class ConsultingController {
	
	@Autowired
	private ConsultingService consultService;
	
	
	// 상담 내역 조회 교수,교수번호 같이보내서 조회
		@RequestMapping("/consultList")
	   public ModelAndView consultingList(ModelAndView mv,HttpSession session) {
		   Professor professor = (Professor)session.getAttribute("loginprof");
		   int pNo = professor.getpNo();
		   List<Consulting> proconsultList = consultService.proconsultingList(pNo);
		   mv.addObject("proconsultList", proconsultList);
		   mv.setViewName("professor/profConsultingList");
	      return mv;
	   }
	   
	   // 상담글 상세 보기
		@RequestMapping("/consultDetail")
	   public ModelAndView consultingDetail(ModelAndView mv,HttpSession session,int sNo, int cNo) {
		   Student student = (Student)session.getAttribute("loginStudent");
		   mv.addObject("loginStudent", student);
		   mv.addObject("consultDetail",consultService.consultingDetail(cNo));
		   mv.setViewName("student/stuConsultingDetail");
		   return mv;
	   }
		
	   // 교수가 상담글 상세 보기
			@RequestMapping("/proconsultDetail")
		   public ModelAndView proconsultingDetail(ModelAndView mv,HttpSession session, int cNo, int sNo, String sName) {
			   mv.addObject("consultDetail",consultService.consultingDetail(cNo));
			   mv.addObject("sName", sName);
			   mv.addObject("sNo", sNo);
			   mv.addObject("cNo", cNo);
			   mv.setViewName("professor/proConsultingDetail");
			   return mv;
		   }
	   
	   // 상담글 작성
	   @RequestMapping(value="/insertConsulting", method=RequestMethod.POST)
	   public String insertConsulting(Consulting cons,HttpSession session) {
		   Student student = (Student)session.getAttribute("loginStudent");
		   cons.setpNo(student.getpNo());
		   cons.setsNo(student.getsNo());
		   cons.setpName(student.getpName());
		   cons.setsGrade(student.getsGrade());
		   
		  int result = consultService.insertConsulting(cons);
		  if (result>0) {return "redirect:/stuConsultingList";}
		  else {return "home";}
	   }
	   
	   // 상담글 수정
	   public String updateConsulting(Consulting cons, int cNo) {
	      return null;
	   }
	   
	   // 상담글 삭제
	   public String deleteConsulting(int cNo) {
	      return null;
	   }
	   // 답변글 작성(업데이트 형식)
	   @RequestMapping(value="/insertAnswer", method=RequestMethod.POST)
	   public String createAnswer(Consulting cons) {
		   
		   int result = consultService.insertAnswer(cons);
		   if(result>0)
		   {
			   return "redirect:/consultList";
		   }
		   else {
	      return "redirect:/consultList";
		   }
	   }
	   
	   // 답변글 수정 //eq로 작성자만
	   public String updateAnswer(Consulting cons, int cNo) {
	      return null;
	   }
	   
	   @RequestMapping("/stuConsultingList")
	   public ModelAndView changConsultingList(ModelAndView mv, HttpSession session){
		   Student student = (Student)session.getAttribute("loginStudent");
		   int studentNo = student.getsNo();
		   List<Consulting> consultList = consultService.consultingList(studentNo);
		   mv.addObject("consultingList",consultList);
		   mv.addObject("loginStudent", student);
		   mv.setViewName("student/stuConsultingList");
		   return mv;
		   
	   }
	   
		@RequestMapping("stuWriteConsulting")
		public ModelAndView writeConsulting(ModelAndView mv, HttpSession session) {
			Student student = (Student)session.getAttribute("loginStudent");
			Professor findPname = consultService.findPName(student.getsNo());
			String pName = findPname.getpName();
			mv.addObject("pName", pName);
			 mv.addObject("loginStudent", student);
			 mv.setViewName("student/stuWriteConsulting");
			return mv;
		}
		
		

}
