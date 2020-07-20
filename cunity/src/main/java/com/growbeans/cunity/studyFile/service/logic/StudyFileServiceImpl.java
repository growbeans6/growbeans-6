package com.growbeans.cunity.studyFile.service.logic;

import java.util.ArrayList;

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
		return studyFileStore.uploadStudyFile(studyFile);
	}

	@Override
	public int deleteStudyFile(int fileNo) {
		return studyFileStore.deleteStudyFile(fileNo);

	}

	@Override
	public StudyFile selectOneStudyFile(int fileNo) {
		return studyFileStore.selectOneStudyFile(fileNo);
	}
}
