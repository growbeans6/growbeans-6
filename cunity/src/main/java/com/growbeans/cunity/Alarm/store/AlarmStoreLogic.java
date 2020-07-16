package com.growbeans.cunity.Alarm.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.post.domain.Post;

@Repository("alarmStore")
public class AlarmStoreLogic implements AlarmStore{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertAlarmPost(Alarm alarm) {
		return sqlSession.insert("alarmMapper.insertAlarmPost", alarm);
	}
	
	@Override
	public int insertAlarmFriends(Alarm alarm) {
		return sqlSession.insert("alarmMapper.insertAlarmFriends", alarm);
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

	@Override
	public int countAlarm(int sNo) {
		return sqlSession.selectOne("alarmMapper.countAlarm", sNo);
	}
}
