package com.growbeans.cunity.student.store;

import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;

public interface StudentStore {
	
	   public Student loginStudent(Student student);
	   public int modifyMember(Student student);
	   public ModelAndView studentInfo(int sNo);
	   
}
