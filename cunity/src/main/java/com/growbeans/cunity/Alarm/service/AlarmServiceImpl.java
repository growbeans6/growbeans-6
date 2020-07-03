package com.growbeans.cunity.Alarm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.Alarm.store.AlarmStore;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{

	@Autowired
	public AlarmStore alarmStore;

	@Override
	public int insertAlarm(Alarm alarm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAlarm(int aNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Alarm> selectAlarmList(int sNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
