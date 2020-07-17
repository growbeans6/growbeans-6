package com.growbeans.cunity.grade.store;



import java.util.ArrayList;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;

public interface GradeStore {
	
	public ArrayList<Grade> selectGrade();
	public int insertGrade(LectureEnrollment lectureEn);



}
