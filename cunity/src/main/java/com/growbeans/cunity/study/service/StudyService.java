package com.growbeans.cunity.study.service;

import java.util.ArrayList;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.study.domain.Study;

public interface StudyService {
	/**  
	 * 1. 스터디 생성
	 * @param study
	 * @return result
	 */
	public int createStudy(Study study);
	
	/**
	 * 2-1. 스터디 해체
	 * @param studyNo
	 * @return result
	 */
	public int deleteStudy(int studyNo);
	
	
	/**
	 * 3. 스터디 이름 변경
	 * @param study
	 * @return result
	 */
	public int modifyStudyName(Study study);
	
	/**
	 * 4. 스터디 관리자 변경
	 * @param study
	 * @return result
	 */
	public int modifyStudyManager(Study study);
	
	/**
	 * 5-1. 스터디 가입 수락
	 * @param student
	 * @return result
	 */
	public int joinStudy(Student student);
	
	/**
	 * 6. 스터디 탈퇴
	 * @param StudentNo
	 * @return result
	 */
	public int withdrawStudy(int studentNo); 
	
	/**
	 * 7. 스터디 정보 불러오기
	 * @param StudentNo
	 * @return study
	 */
	public Study selectStudy(int studentNo);
	
	/**
	 * 8. 스터디 가입자 명단 불러오기
	 * @param Study
	 * @return studentList
	 */
	public ArrayList<Student> selectStudyStudentList(int studyNo);
}
