package com.growbeans.cunity.grade.service;


import java.util.ArrayList;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;

public interface GradeService {

	public ArrayList<Grade> selectGrade();
	public int insertGrade(LectureEnrollment lectureEn);

}
