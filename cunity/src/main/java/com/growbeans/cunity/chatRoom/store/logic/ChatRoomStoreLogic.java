package com.growbeans.cunity.chatRoom.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.chatRoom.domain.ChatRoom;
import com.growbeans.cunity.chatRoom.mapper.ChatRoomMapper;
import com.growbeans.cunity.chatRoom.store.ChatRoomStore;
import com.growbeans.cunity.student.domain.Student;

@Repository("chatRoomStoreLogic")
public class ChatRoomStoreLogic implements ChatRoomStore{
	
	@Autowired
	private SqlSession session;

	public Student loginTest(String id) {
		ChatRoomMapper chatRoomMapper = session.getMapper(ChatRoomMapper.class);
		Student student = chatRoomMapper.loginTest(id);
		return student;
	}
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
