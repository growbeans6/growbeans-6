package com.growbeans.cunity.lectureEvaluation.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.grade.domain.Grade;
import com.growbeans.cunity.lectureEvaluation.domain.LectureEvaluation;
import com.growbeans.cunity.lectureEvaluation.service.LectureEvaluationService;
import com.growbeans.cunity.lectureEvaluation.store.LectureEvaluationStore;

@Service("lecEvaService")
public class LectureEvaluationServiceImpl implements LectureEvaluationService {
	
	@Autowired
	private LectureEvaluationStore lecEvaStore;

	@Override
	public int insertEval(LectureEvaluation lecEval) {
		return lecEvaStore.insertEval(lecEval);
	}

	

}
