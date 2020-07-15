package com.growbeans.cunity.consulting.service.logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.consulting.domain.Consulting;
import com.growbeans.cunity.consulting.service.ConsultingService;
import com.growbeans.cunity.consulting.store.ConsultingStore;
import com.growbeans.cunity.professor.domain.Professor;


@Service("conService")
public class ConsultingServiceImpl implements ConsultingService {
	
	@Autowired
	private ConsultingStore conStore;

	@Override
	public List<Consulting> consultingList(int sNo) {
		return conStore.consultingList(sNo);
	}
	
	@Override
	public List<Consulting> proconsultingList(int pNo) {
		return conStore.proconsultingList(pNo);
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
	public Professor findPName(int sNo) {
		return conStore.findPName(sNo);
	}
	

	@Override
	public int updateConsulting(Consulting cons, int cNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAnswer(Consulting cons) {
		return conStore.insertAnswer(cons);
	}

	@Override
	public int updateAnswer(Consulting cons, int cNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	



}
