package com.growbeans.cunity.lectureEnrollment.store;


import java.util.ArrayList;
import java.util.List;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;

public interface LectureEnrollmentStore {

	public int insertEnList(LectureEnrollment lecEn);
	public List<Lecture> lectureEnList(int sNo);
	public int deleteEnList(int lCode);

}
