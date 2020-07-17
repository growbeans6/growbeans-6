package com.growbeans.cunity.grade.store.Logic;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.grade.store.GradeStore;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;

@Repository("gradeStore")
public class GradeStoreLogic implements GradeStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Grade> selectGrade() {
		return null;
	}

	public int insertGrade(Grade grade) {
		return sqlSession.update("gradeMapper.insertGrade", grade);
	}

	@Override
	public int insertGrade(LectureEnrollment lectureEn) {
		return sqlSession.update("gradeMapper.insertGrade", lectureEn);
	}


}
