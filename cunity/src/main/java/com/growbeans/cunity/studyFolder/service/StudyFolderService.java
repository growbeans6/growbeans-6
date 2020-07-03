package com.growbeans.cunity.studyFolder.service;

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
		
	
}
