package com.growbeans.cunity.professor.store.logic;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.professor.store.ProfessorStore;
import com.growbeans.cunity.student.domain.Student;

@Repository("pStore")
public class ProfessorStoreLogic implements ProfessorStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Professor professorInfo(int pNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProfessorInfo(Professor prof) {
		return sqlSession.update("professorMapper.updateProfessor", prof);
		
	}

	@Override
	public ArrayList<Student> guidanceList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 교수 로그인
	@Override
	public Professor selectProfessor(Professor prof) {
		Professor profLogin = sqlSession.selectOne("professorMapper.selectOne", prof);
		return profLogin;
	}


}
