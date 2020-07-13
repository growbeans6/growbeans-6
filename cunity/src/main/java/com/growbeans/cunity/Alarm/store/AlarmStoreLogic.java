package com.growbeans.cunity.Alarm.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.Alarm.domain.Alarm;

@Repository("alarmStore")
public class AlarmStoreLogic implements AlarmStore{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertAlarm(Alarm alarm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAlarm(int aNo) {
		return sqlSession.delete("alarmMapper.deleteAlarm", aNo);
	}

	@Override
	public ArrayList<Alarm> selectAlarmList(int sNo) {
		return (ArrayList)sqlSession.selectList("alarmMapper.selectAlarmList", sNo);
	}

	@Override
	public Alarm selectAlarm(int aNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
