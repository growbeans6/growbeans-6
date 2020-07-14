package com.growbeans.cunity.chatRoom.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.growbeans.cunity.chatRoom.domain.ChatRoom;
import com.growbeans.cunity.chatRoom.service.ChatRoomService;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.study.service.StudyService;

@SessionAttributes({"loginUser"})
@Controller
public class ChatRoomController {
	
	@Autowired
	private ChatRoomService chatRoomService;
	@Autowired
	private StudyService studyService;
	
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
	public String chatRoom(Model mo,HttpSession session,RedirectAttributes ra) {
		Student student = (Student)session.getAttribute("loginStudent");
		if(student.getStudyNo()==0) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		ArrayList<Student> sList = studyService.selectStudyStudentList(student.getStudyNo());

		mo.addAttribute("studyMemberList", sList);
		return "study/studyChat";
	}
	// 채팅방 입장인원 리스트 전송 ajax
	@RequestMapping("/rMember")
	public void chatMember(HttpServletResponse response, int studyNo) throws JsonIOException, IOException {
		ArrayList<ChatRoom> rlist = chatRoomService.selectRoomMemberList(studyNo);
		Gson gson = new GsonBuilder().create();
		gson.toJson(rlist, response.getWriter());
	}
}
