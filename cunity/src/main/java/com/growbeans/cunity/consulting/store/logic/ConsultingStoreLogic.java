package com.growbeans.cunity.consulting.store.logic;


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.consulting.domain.Consulting;
import com.growbeans.cunity.consulting.store.ConsultingStore;
import com.growbeans.cunity.professor.domain.Professor;


@Repository("conStore")
public class ConsultingStoreLogic implements ConsultingStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Consulting> consultingList(int sNo) {
		return sqlSession.selectList("consultingMapper.consultingList", sNo);
	}
	
	@Override
	public List<Consulting> proconsultingList(int pNo) {
		return sqlSession.selectList("consultingMapper.proconsultingList", pNo);
	}

	@Override
	public Consulting consultingDetail(int cNo) {
		return sqlSession.selectOne("consultingMapper.consultingDetail", cNo);
	}

	@Override
	public int insertConsulting(Consulting cons) {
		return sqlSession.insert("consultingMapper.insertConsult", cons);
	}
	@Override
	public Professor findPName(int sNo) {
		return sqlSession.selectOne("professorMapper.findPName", sNo);
	}


	@Override
	public int updateConsulting(Consulting cons, int cNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAnswer(Consulting cons) {
		return sqlSession.update("consultingMapper.insertAnswer", cons);
	}

	@Override
	public int updateAnswer(Consulting cons, int cNo) {
		// TODO Auto-generated method stub
		return 0;
	}



	

}
