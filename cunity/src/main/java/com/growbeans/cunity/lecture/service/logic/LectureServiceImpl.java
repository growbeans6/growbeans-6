package com.growbeans.cunity.lecture.service.logic;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;
import com.growbeans.cunity.lecture.store.LectureStore;
import com.growbeans.cunity.student.domain.Student;

@Service("lecService")
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureStore lecStore;

	@Override
	public List<Lecture> allLectureList() {
		return lecStore.allLectureList();
	}
	
	//교수별 강의하는 목록보기
	@Override
	public List<Lecture> proLectureList(int pNo) {
		return lecStore.proLectureList(pNo);
	}
	
	//과목코드별 수강생 조회
	@Override
	public List<Student> lecStudentList(int lCode) {
		return lecStore.lecStudentList(lCode);
	}

	@Override
	public int insertLecture(Lecture lec) {
		return lecStore.insertLecture(lec);
	}

	@Override
	public int deleteLecture(int lCode) {
		return lecStore.deleteLecture(lCode);
	}
	
	@Override
	public ArrayList<Student> allStudentList() {
		return null;
	}

	@Override
	public ArrayList<Lecture> lectureTime() {
		return null;
	}

	

	



}
