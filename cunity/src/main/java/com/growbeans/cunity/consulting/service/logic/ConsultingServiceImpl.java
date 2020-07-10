package com.growbeans.cunity.consulting.service.logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.consulting.domain.Consulting;
import com.growbeans.cunity.consulting.service.ConsultingService;
import com.growbeans.cunity.consulting.store.ConsultingStore;


@Service("conService")
public class ConsultingServiceImpl implements ConsultingService {
	
	@Autowired
	private ConsultingStore conStore;

	@Override
	public List<Consulting> consultingList(int sNo) {
		return conStore.consultingList(sNo);
	}

	@Override
	public Consulting consultingDetail(int cNo) {
		return conStore.consultingDetail(cNo);
	}

	@Override
	public int insertConsulting(Consulting cons) {
		return conStore.insertConsulting(cons);
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
