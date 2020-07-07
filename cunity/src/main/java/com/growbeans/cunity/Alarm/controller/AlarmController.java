package com.growbeans.cunity.Alarm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.Alarm.service.AlarmService;

@Controller
public class AlarmController {

	@Autowired
	public AlarmService alarmService;
	
	// 알람 목록 불러오기
	  @RequestMapping("alarmList")
	   public ModelAndView noticeList(ModelAndView mv, int sNo) {
	      ArrayList<Alarm> alarm = alarmService.selectAlarmList(sNo);
	      
	      if (!alarm.isEmpty()) {
	         mv.addObject("alarm", alarm);
	         mv.setViewName("community/alarm");
	      } else {
	         mv.addObject("msg", "알람 목록 조회 실패");
	         mv.setViewName("common/errorPage");
	      }
	      return mv;
	   }
	  
	// 알람 삭제
	   // 1. DB 데이터 삭제
	   // 2. 삭제 후 alert 창 후 목록으로 redirect
	   @RequestMapping("deleteAlarm")
	   public String alarmDelete(int aNo, Model model, HttpServletRequest request, RedirectAttributes rd) {
		   Alarm alarm = alarmService.selectAlarm(aNo);
		   int result = alarmService.deleteAlarm(aNo);
		   if(result > 0) {
			   rd.addFlashAttribute("msg", "알람 삭제 성공");
			   return "alarmlist";
		   } else {
			   model.addAttribute("msg", "알람 삭제 실패");
			   return "common/errorPage";
		   }
	   }
}
