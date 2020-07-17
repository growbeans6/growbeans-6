package com.growbeans.cunity.foreignActivities.mapper;

import com.growbeans.cunity.foreignActivities.domain.ForeignActivities;

public interface ForeignActivitiesMapper {
	
	
	
	//mapper에서 id의 이름이랑 맞춰준다.
	public int insertForeignAct(ForeignActivities fAct);
	public ForeignActivities foreignInfo(int sNo);

}
