package com.growbeans.cunity.grade.store;



import java.util.ArrayList;

import com.growbeans.cunity.grade.domain.Grade;

public interface GradeStore {
	
	public ArrayList<Grade> selectGrade();
	public int insertGrade(Grade grade);



}
