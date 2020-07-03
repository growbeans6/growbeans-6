package com.growbeans.cunity.professor.service.logic;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.professor.service.ProfessorService;
import com.growbeans.cunity.professor.store.ProfessorStore;
import com.growbeans.cunity.student.domain.Student;


@Service("proService")
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorStore proStore;

	@Override
	public Professor professorInfo(int pNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProfessorInfo(Professor pro, int pNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Student> guidanceList() {
		// TODO Auto-generated method stub
		return null;
	}

}
