package com.growbeans.cunity.friends.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.student.domain.Student;

public interface FriendsService {

	/**
	 * 1. 친구 요청 메시지 보내기
	 * @param fMessage
	 * @return result
	 */
	public int insertFriends(Friends friends);
	
	/**
	 * 2. 친구 요청 메시지 받기
	 * @param fMessage
	 * @return
	 */
	public int receiveFriends(String fMessage);
	
	/**
	 * 3. 친구 목록 보여주기(response, request 완료)
	 * @param sNo
	 * @return
	 */
	public ArrayList<Student> selectFriendsList(int sNo);
	
	/**
	 * 4. 친구 삭제
	 * @param lNo
	 * @return
	 */
	public int deleteFriends(int lNo);
	
	/**
	 * 5. 친구 찾기
	 * @param sName
	 * @return
	 */
	public ArrayList<Student> findFriends(String sName);
	
	/**
	 * 받은 친구 신청 확인하기 위해 불러오기
	 */
	public ArrayList<Friends> selectFriendsRequest(int sessionSNo);
}
