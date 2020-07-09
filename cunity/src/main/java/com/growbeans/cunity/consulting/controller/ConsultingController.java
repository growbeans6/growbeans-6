package com.growbeans.cunity.consulting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.consulting.domain.Consulting;
import com.growbeans.cunity.consulting.service.ConsultingService;

@Controller
public class ConsultingController {
	
	@Autowired
	private ConsultingService consultService;
	
	
	// 상담 내역 조회 교수,교수번호 같이보내서 조회
		@RequestMapping("/consultList")
	   public ModelAndView consultingList(ModelAndView mv) {
		   mv.setViewName("professor/profConsultingList");
	      return mv;
	   }
	   
	   // 상담글 상세 보기
	   public ModelAndView consultingDetail(ModelAndView mv, int cNo) {
	      return mv;
	   }
	   
	   // 상담글 작성
	   public String insertConsulting(Consulting cons) {
	      return null;
	   }
	   
	   // 상담글 수정
	   public String updateConsulting(Consulting cons, int cNo) {
	      return null;
	   }
	   
	   // 상담글 삭제
	   public String deleteConsulting(int cNo) {
	      return null;
	   }
	   // 답변글 작성
	   public String createAnswer(Consulting cons) {
	      return null;
	   }
	   
	   // 답변글 수정 //eq로 작성자만
	   public String updateAnswer(Consulting cons, int cNo) {
	      return null;
	   }
	   
	   @RequestMapping("/stuConsultingList")
	   public String changConsultingList(){
		   return "student/stuConsultingList";
	   }
	   
		@RequestMapping("stuWriteConsulting")
		public String writeConsulting() {
			return "/student/stuWriteConsulting";
		}

}
