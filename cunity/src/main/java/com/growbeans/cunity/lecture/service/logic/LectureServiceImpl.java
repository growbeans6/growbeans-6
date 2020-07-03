package com.growbeans.cunity.lecture.service.logic;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;
import com.growbeans.cunity.lecture.store.LectureStore;

@Service("lecService")
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureStore lecStore;

	@Override
	public ArrayList<Lecture> allLectureList() {
		return null;
	}

	@Override
	public int insertLecture(Lecture lec) {
		return 0;
	}

	@Override
	public int deleteLecture(int lCode) {
		return 0;
	}



}
