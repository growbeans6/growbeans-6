package com.growbeans.cunity.chatRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.chatRoom.service.ChatRoomService;
import com.growbeans.cunity.student.domain.Student;

@SessionAttributes({"loginUser"})
@Controller
public class ChatRoomController {
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	// 로그인 테스트 폼입장
		@RequestMapping("/lgForm")
		public ModelAndView lgForm(ModelAndView mv) {
			mv.setViewName("study/loginTest");
			return mv;
		}
	// 채팅방 입장 로그인 (테스트용)
	@RequestMapping("/loginTest")
	public ModelAndView chatLogin(ModelAndView mv, String id) {
		Student student = null;
		student = chatRoomService.loginTest(id);
		mv.addObject("loginUser", student);
		mv.setViewName("redirect:/chatRoom");
		return mv;
	}
	// 채팅방 입장
	@RequestMapping("/chatRoom")
	public ModelAndView chatRoom(ModelAndView mv) {
		mv.setViewName("study/studyChat");
		return mv;
	}
	// 채팅방 입장인원 리스트 전송 ajax
	public void chatMember() {
		
	}
}
