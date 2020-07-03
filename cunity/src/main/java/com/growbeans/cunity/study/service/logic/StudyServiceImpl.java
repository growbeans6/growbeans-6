package com.growbeans.cunity.study.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.study.domain.Study;
import com.growbeans.cunity.study.service.StudyService;
import com.growbeans.cunity.study.store.StudyStore;

@Service("studyService")
public class StudyServiceImpl implements StudyService{
 
	@Autowired
	private StudyStore studyStore;
	
	@Override
	public int createStudy(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudy(int studyNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudyName(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudyManager(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int joinStudy(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdrawStudy(int StudentNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Study selectStudy(int StudentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> selectStudyStudentList(int Study) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
