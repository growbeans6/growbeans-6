package com.growbeans.cunity.lectureEvaluation.store.logic;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.lectureEvaluation.domain.LectureEvaluation;
import com.growbeans.cunity.lectureEvaluation.store.LectureEvaluationStore;

@Repository("lecEvaStore")
public class LectureEvaluationStoreLogic implements LectureEvaluationStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertEval(LectureEvaluation lecEval) {
		return sqlSession.insert("lectureEvaluationMapper.insertEval",lecEval);
	}

}
