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
		Student loginStudent = sqlSession.selectOne("studentMapper.loginStudent", student);
		return loginStudent;
	}

	@Override
	public int modifyStudent(Student student) {
		return sqlSession.insert("studentMapper.modifyStudent", student);
	}



}
