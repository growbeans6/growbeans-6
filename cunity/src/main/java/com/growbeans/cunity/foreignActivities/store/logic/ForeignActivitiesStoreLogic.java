package com.growbeans.cunity.foreignActivities.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.foreignActivities.store.ForeignActivitiesStore;

@Repository("ForeignActivitiesStore")
public class ForeignActivitiesStoreLogic implements ForeignActivitiesStore{

	@Autowired
	private SqlSession session;
}
