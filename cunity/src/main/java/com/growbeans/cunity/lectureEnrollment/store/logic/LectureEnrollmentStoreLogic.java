package com.growbeans.cunity.lectureEnrollment.store.logic;


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;
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

	@Override
	public Lecture lectureOne(int lCode) {
		return sqlSession.selectOne("lectureMapper.lectureOne", lCode);
	}

	@Override
	public int updateSchedule(Timetable table) {
		return sqlSession.update("timetableMapper.updateTime", table);
	}
	
	@Override
	public int updateProSchedule(Timetable table) {
		return sqlSession.update("timetableMapper.updateProTime", table);
	}

	@Override
	public Timetable showList(int sNo) {
		return sqlSession.selectOne("timetableMapper.showTime", sNo);
	}
	
	@Override
	public Timetable showProList(int pNo) {
		return sqlSession.selectOne("timetableMapper.showProTime", pNo);
	}

	@Override
	public LectureEnrollment find(LectureEnrollment lecture) {
		return sqlSession.selectOne("LectureEnrollmentMapper.findLecture", lecture);
	}

	@Override
	public Lecture alreadyLecture(Lecture lecture) {
		return sqlSession.selectOne("lectureMapper.alreadyLecture", lecture);
	}
	
	@Override
	public List<Lecture> alreadyProLecture(Lecture compareLec) {
		return sqlSession.selectList("lectureMapper.alreadyProLecture", compareLec);
	}

	@Override
	public int insertGrade(LectureEnrollment lectureEn) {
		return sqlSession.update("LectureEnrollmentMapper.insertGrade",lectureEn);
	}

	@Override
	public List<LectureEnrollment> gradeList(int sNo) {
		return sqlSession.selectList("LectureEnrollmentMapper.gradeList", sNo);
	}






	

}
