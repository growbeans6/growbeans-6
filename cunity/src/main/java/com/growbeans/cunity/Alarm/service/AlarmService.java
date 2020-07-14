package com.growbeans.cunity.Alarm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.post.domain.Post;

public interface AlarmService {

	/**
	 * 1. 게시글 관련 알람 추가
	 * @param alarm
	 * @return result
	 */
	public int insertAlarmPost(Alarm alarm);
	
	/**
	 * 1-1 친구 관련 알람 추가
	 * @param alarm
	 * @return
	 */
	public int insertAlarmFriends(Alarm alarm);
	
	/**
	 * 2. 알람 제거
	 * @param aNo
	 * @return result
	 */
	public int deleteAlarm(int aNo);
	
	/**
	 * 3. 알람 목록 보기
	 * @param sNo
	 * @return list
	 */
	public ArrayList<Alarm> selectAlarmList(int sNo);
	/**
	 * 4. 알람 한 개 선택
	 * @param aNo
	 * @return alarm
	 */
	public Alarm selectAlarm(int aNo);
	
}
