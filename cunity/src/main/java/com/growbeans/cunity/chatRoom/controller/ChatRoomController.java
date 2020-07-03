package com.growbeans.cunity.chatRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.chatRoom.service.ChatRoomService;

@Controller
public class ChatRoomController {
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	// 채팅방 입장
	public ModelAndView chatRoom() {
		return null;
	}
	// 채팅방 입장인원 리스트 전송 ajax
	public void chatMember() {
		
	}
}
