package com.growbeans.cunity.Alarm.store;

import java.util.ArrayList;

import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.post.domain.Post;

public interface AlarmStore {

	public int insertAlarmPost(Alarm alarm);
	public int insertAlarmFriends(Alarm alarm);
	public int deleteAlarm(int aNo);
	public ArrayList<Alarm> selectAlarmList(int sNo);
	public Alarm selectAlarm(int aNo);
	public int countAlarm(int sNo);
}
