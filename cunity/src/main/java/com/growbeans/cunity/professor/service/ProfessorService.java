package com.growbeans.cunity.professor.service;


import java.util.ArrayList;


import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.student.domain.Student;

public interface ProfessorService {
	
	   public Professor professorInfo(int pNo);
	   public int updateProfessorInfo(Professor pro, int pNo);
	   public ArrayList<Student> guidanceList();


}
