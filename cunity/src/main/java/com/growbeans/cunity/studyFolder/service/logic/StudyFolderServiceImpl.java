package com.growbeans.cunity.studyFolder.service.logic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;
import com.growbeans.cunity.studyFolder.store.StudyFolderStoreLogic;

@Service("studyFolderService")
public class StudyFolderServiceImpl implements StudyFolderService {

	@Autowired
	private StudyFolderStoreLogic studyFolderStore;

	// studyFolder 하나 선택해서 studyfile list 출력
	/*@Override
	public StudyFolder selectOneFolder(StudyFolder studyFolder) {

		return null;
	}*/

	// studyFolder 생성
	@Override
	public int insertStudyFolder(StudyFolder studyFolder, HttpServletRequest request) {

		return studyFolderStore.insertStudyFolder(studyFolder, request);
	}

	// studyFolder 삭제
	@Override
	public int deleteStudyFolder(int folderNo) {
		int result = studyFolderStore.deleteStudyFolder(folderNo);
		return result;
	}

}
