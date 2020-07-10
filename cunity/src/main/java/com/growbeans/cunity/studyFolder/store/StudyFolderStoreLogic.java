package com.growbeans.cunity.studyFolder.store;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.studyFile.mapper.StudyFileMapper;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.mapper.StudyFolderMapper;

@Repository("studyFolderStore")
public class StudyFolderStoreLogic {
	
	@Autowired
	private SqlSession sqlsession;
	// studyFolder 하나 선택
	public StudyFolder selectOneFolder(StudyFolder studyFolder) {
		return null;
	}
	// studyFolder 생성
	public int insertStudyFolder(StudyFolder studyFolder, HttpServletRequest request) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		int result = studyfolderMapper.insertStudyFolder(studyFolder);
		return result;
	}
	// studyFolder 삭제
	public int deleteStudyFolder(int folderNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		int result = studyfolderMapper.deleteStudyFolder(folderNo);
		return result;
	}
}
