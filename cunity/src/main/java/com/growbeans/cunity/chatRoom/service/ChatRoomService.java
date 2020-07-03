package com.growbeans.cunity.chatRoom.service;

import com.growbeans.cunity.chatRoom.domain.ChatRoom;

public interface ChatRoomService {
	/**
	 * 1. 채팅룸 입장
	 * @param chatRoom
	 * @return result
	 */
	public int entranceRoom(ChatRoom chatRoom);
	
	/**
	 * 2. 채팅룸 퇴장
	 * @param studentNo
	 * @return result
	 */
	public int exitRoom(int studentNo);
	
	/**
	 * 3. 채팅룸 입장멤버 조회
	 * @param studyNo
	 * @return chatRoom
	 */
	public ChatRoom selectRoomMemberList(int studyNo);
}
