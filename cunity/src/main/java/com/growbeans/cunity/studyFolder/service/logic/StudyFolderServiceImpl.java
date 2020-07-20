package com.growbeans.cunity.studyFolder.service.logic;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;
import com.growbeans.cunity.studyFolder.store.StudyFolderStoreLogic;

@Service("studyFolderService")
public class StudyFolderServiceImpl implements StudyFolderService {

	@Autowired
	private StudyFolderStoreLogic studyFolderStore;

	// studyFolder list 조회
	@Override
	public ArrayList<StudyFolder> selectlistFolder(int studyNo, int folderNo) {
		return studyFolderStore.selectlist(studyNo, folderNo);
	}

	// studyFolder 생성
	@Override
	public int insertStudyFolder(String folderName) {

		return studyFolderStore.insertStudyFolder(folderName);
	}

	// studyFolder 삭제
	@Override
	public int deleteStudyFolder(int folderNo) {
		int result = studyFolderStore.deleteStudyFolder(folderNo);
		return result;
	}

	// studyFolder 하나 조회
	@Override
	public StudyFolder selectOneFolder(int studyNo) {
		return studyFolderStore.selectOneFolder(studyNo);
	}

	// studyFolder 하나의 내용 조회
	@Override
	public ArrayList<StudyFolder> selectlistOneStudyFolder(int studyNo, int folderNo) {
		// TODO Auto-generated method stub
		return studyFolderStore.selectlistOneStudyFolder(studyNo, folderNo);
	}
	
	// 특정 studyFolder의 studyFile 리스트 불러오기
	@Override
	public ArrayList<StudyFile> selectlistStudyFile(int studyNo, int folderNo) {
		// TODO Auto-generated method stub
		return studyFolderStore.selectlistStudyFile(studyNo, folderNo);
	}

	

}
