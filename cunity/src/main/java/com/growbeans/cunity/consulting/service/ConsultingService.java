package com.growbeans.cunity.consulting.service;


import java.util.ArrayList;
import java.util.List;

import com.growbeans.cunity.consulting.domain.Consulting;

public interface ConsultingService {
	
	
	public List<Consulting> consultingList (int sNo);
	public Consulting consultingDetail (int cNo);
	public int insertConsulting(Consulting cons);
	public int updateConsulting(Consulting cons, int cNo);
	public int insertAnswer(Consulting cons);
	public int updateAnswer(Consulting cons, int cNo);


}
