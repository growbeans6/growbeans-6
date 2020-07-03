package com.growbeans.cunity.studyFolder.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;
import com.growbeans.cunity.studyFolder.store.StudyFolderStoreLogic;

@Service("studyFolderService")
public class StudyFolderServiceImpl implements StudyFolderService {
	
	@Autowired
	private StudyFolderStoreLogic studyFolderStore;
	// studyFolder 생성
	@Override
	public int insertStudyFolder(StudyFolder studyFolder) {
		int result = studyFolderStore.insertStudyFolder(studyFolder);
		return result;
	}
	// studyFolder 삭제
	@Override
	public int deleteStudyFolder(int folderNo) {
		int result = studyFolderStore.deleteStudyFolder(folderNo);
		return result;
	}
	
	
}
