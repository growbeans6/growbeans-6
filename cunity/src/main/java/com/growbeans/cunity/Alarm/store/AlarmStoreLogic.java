package com.growbeans.cunity.Alarm.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("alarmStore")
public class AlarmStoreLogic implements AlarmStore{

	@Autowired
	private SqlSession session;
	
}
