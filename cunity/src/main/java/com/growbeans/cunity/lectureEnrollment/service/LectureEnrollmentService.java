package com.growbeans.cunity.lectureEnrollment.service;

import java.util.ArrayList;
import java.util.List;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;


public interface LectureEnrollmentService {

	public int insertEnList(LectureEnrollment lecEn);
	public List<Lecture> lectureEnList(int sNo);
	public int deleteEnList(int lCode);
	public Lecture lectureOne (int lCode);
	public int updateSchedule(Timetable table);
	public Timetable showList(int sNo);
	public LectureEnrollment find(LectureEnrollment lecture);
	public Lecture alreadyLecture(Lecture lecture);
	public int insertGrade(LectureEnrollment lectureEn);
	public List<LectureEnrollment> gradeList(int sNo);

}
