package com.growbeans.cunity.Alarm.store;

import java.util.ArrayList;

import com.growbeans.cunity.Alarm.domain.Alarm;

public interface AlarmStore {

	public int insertAlarm(Alarm alarm);
	public int deleteAlarm(int aNo);
	public ArrayList<Alarm> selectAlarmList(int sNo);
	public Alarm selectAlarm(int aNo);
}
