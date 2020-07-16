package com.growbeans.cunity.lecturesyllabus.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.lecturesyllabus.domain.LectureSyllabus;
import com.growbeans.cunity.lecturesyllabus.store.LectureSyllabusStore;

@Repository("lecSylStore")
public class LectureSyllabusStoreLogic implements LectureSyllabusStore {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public LectureSyllabus selectOneLecSyl(int lCode) {
		return sqlSession.selectOne("LectureSyllabusMapper.findOneLecture", lCode);
	}


}
