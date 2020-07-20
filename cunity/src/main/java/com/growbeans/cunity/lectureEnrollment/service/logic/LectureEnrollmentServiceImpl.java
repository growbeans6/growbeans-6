package com.growbeans.cunity.lectureEnrollment.service.logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.lectureEnrollment.store.LectureEnrollmentStore;


@Service("lecEnService")
public class LectureEnrollmentServiceImpl implements LectureEnrollmentService {

	@Autowired
	private LectureEnrollmentStore lecEnStore;
	
	@Override
	public int insertEnList(LectureEnrollment lecEn) {
		return lecEnStore.insertEnList(lecEn);
	}

	@Override
	public List<Lecture> lectureEnList(int sNo) {
		return lecEnStore.lectureEnList(sNo);
	}

	@Override
	public int deleteEnList(int lCode) {
		return lecEnStore.deleteEnList(lCode);
	}

	@Override
	public Lecture lectureOne(int lCode) {
		return lecEnStore.lectureOne(lCode);
	}

	@Override
	public int updateSchedule(Timetable table) {
		return lecEnStore.updateSchedule(table);
	}
	
	@Override
	public int updateProSchedule(Timetable table) {
		return lecEnStore.updateProSchedule(table);
	}

	@Override
	public Timetable showList(int sNo) {
		return lecEnStore.showList(sNo);
	}
	
	@Override
	public Timetable showProList(int pNo) {
		return lecEnStore.showProList(pNo);
	}

	@Override
	public LectureEnrollment find(LectureEnrollment lecture) {
		return lecEnStore.find(lecture);
	}

	@Override
	public Lecture alreadyLecture(Lecture lecture) {
		return lecEnStore.alreadyLecture(lecture);
	}
	
	@Override
	public List<Lecture> alreadyProLecture(Lecture compareLec) {
		return lecEnStore.alreadyProLecture(compareLec);
	}

	@Override
	public int insertGrade(LectureEnrollment lectureEn) {
		return lecEnStore.insertGrade(lectureEn);
	}

	@Override
	public List<LectureEnrollment> gradeList(int sNo) {
		return lecEnStore.gradeList(sNo);
	}

	




	
	
	
	

}
