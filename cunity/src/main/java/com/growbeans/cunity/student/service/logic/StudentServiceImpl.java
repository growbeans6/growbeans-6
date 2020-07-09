package com.growbeans.cunity.student.service.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.service.StudentService;
import com.growbeans.cunity.student.store.logic.StudentStoreLogic;

@Service("stuService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentStoreLogic sStore;

	@Override
	public Student loginStudent(Student student) {
		return sStore.loginStudent(student);
	}

	@Override
	public int updateStudent(Student student) {
		return sStore.modifyStudent(student);
	}

}
