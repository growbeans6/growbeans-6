package com.growbeans.cunity.lectureEnrollment.store.logic;


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.store.LectureEnrollmentStore;


@Repository("lecEnStore")
public class LectureEnrollmentStoreLogic implements LectureEnrollmentStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertEnList(LectureEnrollment lecEn) {
		return sqlSession.insert("LectureEnrollmentMapper.insertLectureEnroll", lecEn);
	}

	@Override
	public List<Lecture> lectureEnList(int sNo) {
		return sqlSession.selectList("lectureMapper.enrollLecture",sNo);
	}

	@Override
	public int deleteEnList(int lCode) {
		return sqlSession.delete("LectureEnrollmentMapper.deleteLectureEnroll", lCode);
	}

}
