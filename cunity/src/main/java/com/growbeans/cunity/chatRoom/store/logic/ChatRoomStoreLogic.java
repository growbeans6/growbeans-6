package com.growbeans.cunity.chatRoom.store.logic;

import java.util.ArrayList;

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
		ChatRoomMapper chatRoomMapper = session.getMapper(ChatRoomMapper.class);
		return chatRoomMapper.entranceRoom(chatRoom);
	}

	@Override
	public int exitRoom(int studentNo) {
		ChatRoomMapper chatRoomMapper = session.getMapper(ChatRoomMapper.class);
		return chatRoomMapper.exitRoom(studentNo);
	}

	@Override
	public ArrayList<ChatRoom> selectRoomMemberList(int studyNo) {
		ChatRoomMapper chatRoomMapper = session.getMapper(ChatRoomMapper.class);
		return chatRoomMapper.selectRoomMemberList(studyNo);
	}
}
