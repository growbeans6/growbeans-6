package com.growbeans.cunity.professor.store;


import java.util.ArrayList;

import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.student.domain.Student;

public interface ProfessorStore {
	
	public Professor professorInfo(int pNo);
	   public int updateProfessorInfo(Professor pro, int pNo);
	   public ArrayList<Student> guidanceList();


}
