package com.growbeans.cunity.lectureEnrollment.service.logic;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.lectureEnrollment.store.LectureEnrollmentStore;


@Service("lecEnService")
public class LectureEnrollmentServiceImpl implements LectureEnrollmentService {

	@Autowired
	private LectureEnrollmentStore lecEnStore;
	
	@Override
	public int insertEnList(LectureEnrollment lecEn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Lecture> lectureEnList() {
		// TODO Auto-generated method stub
		return null;
	}

}
