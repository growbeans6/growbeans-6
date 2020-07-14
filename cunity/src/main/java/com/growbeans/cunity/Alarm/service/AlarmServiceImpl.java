package com.growbeans.cunity.Alarm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.Alarm.store.AlarmStore;
import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.post.domain.Post;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{

	@Autowired
	public AlarmStore alarmStore;

	@Override
	public int insertAlarmPost(Alarm alarm) {
		return alarmStore.insertAlarmPost(alarm);
	}
	
	@Override
	public int insertAlarmFriends(Alarm alarm) {
		return alarmStore.insertAlarmFriends(alarm);
	}
	
	@Override
	public int deleteAlarm(int aNo) {
		return alarmStore.deleteAlarm(aNo);
	}

	@Override
	public ArrayList<Alarm> selectAlarmList(int sNo) {
		return alarmStore.selectAlarmList(sNo);
	}

	@Override
	public Alarm selectAlarm(int aNo) {
		
		return null;
	}

}
