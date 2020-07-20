package com.growbeans.cunity.student.store.logic;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.store.StudentStore;


@Repository("sStore")
public class StudentStoreLogic implements StudentStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Student loginStudent(Student student) {
		Student loginStudent = new Student();
		
		if ("".equals(student.getsPassword()) || null == student.getsPassword()) {
			// 패스워드가 없는 경우는 지도학생관리-상세조회에서 사용한다.
			loginStudent = sqlSession.selectOne("studentMapper.studentInfo", student);
		} else {
			// 패스워드가 있는 경우는 로그인한 학생의 정보에서 사용한다.
			loginStudent = sqlSession.selectOne("studentMapper.loginStudent", student);
		}
		
		return loginStudent;
	}

	@Override
	public int modifyStudent(Student student) {
		return sqlSession.insert("studentMapper.modifyStudent", student);
	}



}
