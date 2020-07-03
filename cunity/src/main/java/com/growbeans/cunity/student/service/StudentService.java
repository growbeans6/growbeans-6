package com.growbeans.cunity.student.service;

import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;

public interface StudentService {

	    /**
	    * 회원 로그인 서비스를 위한 메소드
	    * @param student
	    * @return 
	    */
	   public Student loginStudent(Student student);
	   
	   /**
	    * 회원정보 수정을 위한 메소드
	    * @param mem
	    * @return result
	    */
	   public int updateStudent(Student student);
	   
	   /**
	    * 학생정보 조회
	    * @param  sNo
	    * @return 
	    */
	   public Student studentInfo(int sNo);
	   
	   
}
