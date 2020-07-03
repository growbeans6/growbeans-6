package com.growbeans.cunity.consulting.store.logic;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.consulting.domain.Consulting;
import com.growbeans.cunity.consulting.store.ConsultingStore;


@Repository("conStore")
public class ConsultingStoreLogic implements ConsultingStore {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public ArrayList<Consulting> consultingList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulting consultingDetail(int cNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertConsulting(Consulting cons) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateConsulting(Consulting cons, int cNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAnswer(Consulting cons) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAnswer(Consulting cons, int cNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
