package com.growbeans.cunity.study.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.mapper.StudentMapper;
import com.growbeans.cunity.student.store.StudentStore;
import com.growbeans.cunity.study.domain.Study;
import com.growbeans.cunity.study.mapper.StudyMapper;
import com.growbeans.cunity.study.store.StudyStore;

@Repository("studyStore")
public class StudyStoreLogic implements StudyStore{
 
	@Autowired
	private SqlSession session;

	@Override
	public int createStudy(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudy(int studyNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int allWithdrawStudy(int studyNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudyName(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudyManager(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int joinStudy(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteApply(int postNo, int studentNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdrawStudy(int studentNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Study selectStudy(int studentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> selectStudyStudentList(int studyNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		
		return mapper.selectStudyStudentList(studyNo);
	}
	

}
