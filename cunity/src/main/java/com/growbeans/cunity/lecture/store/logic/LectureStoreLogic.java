package com.growbeans.cunity.lecture.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.store.LectureStore;
import com.growbeans.cunity.student.domain.Student;

@Repository("lecStore")
public class LectureStoreLogic implements LectureStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Lecture> allLectureList() {
		return sqlSession.selectList("lectureMapper.allLecture");
	}
	
	
	@Override
	public List<Lecture> proLectureList(int pNo) {
		return sqlSession.selectList("lectureMapper.proLectureList", pNo);
	}

	@Override
	public List<Student> lecStudentList(int lCode) {
		return sqlSession.selectList("studentMapper.lecStudentList", lCode);
	}
	
	@Override
	public int insertLecture(Lecture lec) {
		return sqlSession.insert("lectureMapper.insertLecture", lec);
	}

	@Override
	public int deleteLecture(int lCode) {
		return sqlSession.delete("lectureMapper.deleteLecture", lCode);
	}
	

	@Override
	public ArrayList<Lecture> lectureTime() {
		return null;
	}


	

	
}
