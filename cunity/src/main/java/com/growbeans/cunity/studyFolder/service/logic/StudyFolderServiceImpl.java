package com.growbeans.cunity.studyFolder.service.logic;

import java.util.ArrayList;

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

	
	// studyFolder list 조회
	@Override
	public ArrayList<StudyFolder> selectlistFolder(int studyNo) {
		return studyFolderStore.selectlist(studyNo);
	}

	// studyFolder 생성
	@Override
	public int insertStudyFolder(StudyFolder studyFolder) {

		return studyFolderStore.insertStudyFolder(studyFolder);
	}

	// studyFolder 삭제
	@Override
	public int deleteStudyFolder(int folderNo) {
		int result = studyFolderStore.deleteStudyFolder(folderNo);
		return result;
	}

}
