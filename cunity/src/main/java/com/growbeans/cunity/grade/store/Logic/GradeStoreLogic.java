package com.growbeans.cunity.grade.store.Logic;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.grade.store.GradeStore;

@Repository("gradeStore")
public class GradeStoreLogic implements GradeStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Grade> selectGrade() {
		return null;
	}

	@Override
	public int insertGrade() {
		return 0;
	}


}
