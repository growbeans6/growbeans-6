package com.growbeans.cunity.consulting.store;


import java.util.ArrayList;

import com.growbeans.cunity.consulting.domain.Consulting;

public interface ConsultingStore {
	
	public ArrayList<Consulting> consultingList ();
	public Consulting consultingDetail (int cNo);
	public int insertConsulting(Consulting cons);
	public int updateConsulting(Consulting cons, int cNo);
	public int insertAnswer(Consulting cons);
	public int updateAnswer(Consulting cons, int cNo);


}
