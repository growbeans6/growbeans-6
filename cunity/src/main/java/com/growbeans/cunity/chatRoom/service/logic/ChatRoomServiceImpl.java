package com.growbeans.cunity.chatRoom.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.chatRoom.domain.ChatRoom;
import com.growbeans.cunity.chatRoom.service.ChatRoomService;
import com.growbeans.cunity.chatRoom.store.ChatRoomStore;
import com.growbeans.cunity.student.domain.Student;

@Service("chatRoomService")
public class ChatRoomServiceImpl implements ChatRoomService{

	@Autowired
	private ChatRoomStore chatroomStore;
	
	public Student loginTest(String id) {
		return chatroomStore.loginTest(id);
	}
	
	@Override
	public int entranceRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return chatroomStore.entranceRoom(chatRoom);
	}

	@Override
	public int exitRoom(int studentNo) {
		// TODO Auto-generated method stub
		return chatroomStore.exitRoom(studentNo);
	}

	@Override
	public ArrayList<ChatRoom> selectRoomMemberList(int studyNo) {
		// TODO Auto-generated method stub
		return chatroomStore.selectRoomMemberList(studyNo);
	}

}
