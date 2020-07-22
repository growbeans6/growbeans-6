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

	// 스터디 최상위폴더
	@Override
	public StudyFolder topStudyFolder(int studyNo) {
		// TODO Auto-generated method stub
		return studyFolderStore.topStudyFolder(studyNo);
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

	// 스터디 폴더 리스트 조회
	@Override
	public ArrayList<StudyFolder> selectlistStudyFolder(int folderNo) {
		// TODO Auto-generated method stub
		return studyFolderStore.selectlistStudyFolder(folderNo);
	}

	// 폴더 넘버 조회해서 하나 가져오기
	@Override
	public StudyFolder selectOneStudyFolder(int folderNo) {
		// TODO Auto-generated method stub
		return studyFolderStore.selectOneStudyFolder(folderNo);
	}

	// 특정 studyFolder의 studyFile 리스트 불러오기
	@Override
	public ArrayList<StudyFile> selectlistStudyFile(int studyNo, int folderNo) {
		// TODO Auto-generated method stub
		return studyFolderStore.selectlistStudyFile(studyNo, folderNo);
	}

	// 최근 생성한 폴더 정보 불러오기
	@Override
	public StudyFolder newSelectOneStudyFolder() {
		// TODO Auto-generated method stub
		return studyFolderStore.newSelectOneStudyFolder();
	}

}
