package com.growbeans.cunity.student.store.logic;


import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.store.StudentStore;

public class StudentStoreLogic implements StudentStore {

	@Override
	public Student loginStudent(Student student) {
		return null;
	}

	@Override
	public int modifyMember(Student student) {
		return 0;
	}

	@Override
	public ModelAndView studentInfo(int sNo) {
		return null;
	}


}
