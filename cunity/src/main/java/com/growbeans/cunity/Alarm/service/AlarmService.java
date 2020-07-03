package com.growbeans.cunity.Alarm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.growbeans.cunity.Alarm.domain.Alarm;

public interface AlarmService {

	/**
	 * 1. 알람 추가
	 * @param alarm
	 * @return result
	 */
	public int insertAlarm(Alarm alarm);
	
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
	
	
}
