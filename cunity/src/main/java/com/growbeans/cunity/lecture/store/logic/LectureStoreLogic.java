package com.growbeans.cunity.lecture.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.store.LectureStore;

@Repository("lecStore")
public class LectureStoreLogic implements LectureStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

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
