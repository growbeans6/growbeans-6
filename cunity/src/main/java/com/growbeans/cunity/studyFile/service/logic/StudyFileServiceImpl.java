package com.growbeans.cunity.studyFile.service.logic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.service.StudyFileService;
import com.growbeans.cunity.studyFile.store.StudyFileStoreLogic;

@Service("studyFileService")
public class StudyFileServiceImpl implements StudyFileService {

	@Autowired
	private StudyFileStoreLogic studyFileStore;

	@Override
	public int uploadStudyFile(StudyFile studyFile) {
		int result = studyFileStore.uploadStudyFile(studyFile);
		return result;
	}

	@Override
	public int downloadStudyFile(int fileNo) {
		int result = studyFileStore.downloadStudyFile(fileNo);
		return result;
	}

	@Override
	public int deleteStudyFile(int fileNo) {
		int result = studyFileStore.deleteStudyFile(fileNo);
		return result;
	}

}
