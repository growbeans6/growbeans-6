package com.growbeans.cunity.chatRoom.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.chatRoom.domain.ChatRoom;
import com.growbeans.cunity.chatRoom.service.ChatRoomService;
import com.growbeans.cunity.chatRoom.store.ChatRoomStore;

@Service("chatRoomService")
public class ChatRoomServiceImpl implements ChatRoomService{

	@Autowired
	private ChatRoomStore chatroomStore;
	
	@Override
	public int entranceRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int exitRoom(int studentNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChatRoom selectRoomMemberList(int studyNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
