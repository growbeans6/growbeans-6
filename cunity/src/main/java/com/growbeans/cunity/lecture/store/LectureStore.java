package com.growbeans.cunity.lecture.store;


import java.util.ArrayList;

import com.growbeans.cunity.lecture.domain.Lecture;

public interface LectureStore {
	
	public ArrayList<Lecture> allLectureList();
	public int insertLecture(Lecture lec);
	public int deleteLecture(int lCode);

}
