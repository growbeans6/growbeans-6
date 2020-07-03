package com.growbeans.cunity.friends.service;

import java.util.ArrayList;

import com.growbeans.cunity.friends.domain.Friends;

public interface FriendsService {

	/**
	 * 1. 친구 요청 메시지 보내기
	 * @param fMessage
	 * @return result
	 */
	public int sendFriends(String fMessage);
	
	/**
	 * 2. 친구 요청 메시지 받기
	 * @param fMessage
	 * @return
	 */
	public int receiveFriends(String fMessage);
	
	/**
	 * 3. 친구 목록 보여주기
	 * @param sNo
	 * @return
	 */
	public ArrayList<Friends> selectFriendsList(String sNo);
	
	/**
	 * 4. 친구 삭제
	 * @param lNo
	 * @return
	 */
	public int deleteFriends(int lNo);
}
