package com.growbeans.cunity.lecture.store;


import java.util.ArrayList;
import java.util.List;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.student.domain.Student;

public interface LectureStore {
	
	public List<Lecture> allLectureList();
	public int insertLecture(Lecture lec);
	public int deleteLecture(int lCode);
	public ArrayList<Lecture> lectureTime();
	public List<Lecture> proLectureList(int pNo);
	public List<Student> lecStudentList(int lCode);

}
