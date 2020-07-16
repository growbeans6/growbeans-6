package com.growbeans.cunity.grade.service;


import java.util.ArrayList;

import com.growbeans.cunity.grade.domain.Grade;

public interface GradeService {

	public ArrayList<Grade> selectGrade();
	public int insertGrade(Grade grade);

}
