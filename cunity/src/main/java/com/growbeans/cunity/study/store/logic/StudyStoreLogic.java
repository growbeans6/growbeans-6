package com.growbeans.cunity.study.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.store.StudentStore;

@Repository("studyStore")
public class StudyStoreLogic implements StudentStore{
 
	@Autowired
	private SqlSession session;
	
	@Override
	public Student loginStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ModelAndView studentInfo(int sNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
