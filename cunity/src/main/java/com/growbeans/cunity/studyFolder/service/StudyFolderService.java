package com.growbeans.cunity.studyFolder.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.growbeans.cunity.studyFolder.domain.StudyFolder;

public interface StudyFolderService {
	
	/**
	 * studyFolder를 생성하기 위한 메소드
	 * 
	 * @param studyFolder
	 * @return result
	 */
	public int insertStudyFolder(String folderName);
	
	/**
	 * studyFolder를 삭제하기 위한 메소드
	 * 
	 * @param folderNo
	 * @return result
	 */
	public int deleteStudyFolder(int folderNo);
	/**
	 * studyFolderList를 조회하기 위한 메소드
	 * @param studyNo
	 * @return list
	 */
	public ArrayList<StudyFolder> selectlistFolder(int studyNo);
	/**
	 * studyFolder 하나를 조회하는 메소드
	 * @param studyNo
	 * @return
	 */
	public StudyFolder selectOneFolder(int studyNo);
	/**
	 * studyFolder 하나의 내용을 가져오는 메소드
	 * @param studyNo
	 * @return
	 */
	public ArrayList<StudyFolder> selectlistOneStudyFolder(int studyNo, int folderNo);
	
	/**
	 * 
	 * studyFolder 하나의 파일들을 가져오는 메소드
	 * 
	 * @param folderNo
	 * @return
	 */
	
		
	
	
}
