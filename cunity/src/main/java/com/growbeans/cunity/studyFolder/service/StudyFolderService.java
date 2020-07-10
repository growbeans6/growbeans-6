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
	public int insertStudyFolder(StudyFolder studyFolder);
	
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
		
	
}
