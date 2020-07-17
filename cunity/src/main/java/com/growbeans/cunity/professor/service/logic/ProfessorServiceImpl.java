package com.growbeans.cunity.professor.service.logic;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.professor.service.ProfessorService;
import com.growbeans.cunity.professor.store.ProfessorStore;
import com.growbeans.cunity.professor.store.logic.ProfessorStoreLogic;
import com.growbeans.cunity.student.domain.Student;



@Service("pService")
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorStoreLogic pStore;

	@Override
	public Professor professorInfo(int pNo) {
		return pStore.professorInfo(pNo);
	}

	@Override
	public int updateProfessorInfo(Professor prof) {
		return pStore.updateProfessorInfo(prof);
	}

	@Override
	public ArrayList<Student> guidanceList() {
		return pStore.guidanceList();
	}

	@Override
	public Professor professorLogin(Professor prof) {
		return pStore.selectProfessor(prof);
	}

}
