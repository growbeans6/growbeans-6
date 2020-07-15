package com.growbeans.cunity.studyFolder.store;

import java.util.ArrayList;

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
	public StudyFolder selectOneFolder(int studyNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		return studyfolderMapper.selectOneStudyFolder(studyNo);
	}
	// studyFolder 하나 선택하여 내용 조회
	public ArrayList<StudyFolder> selectlistOneStudyFolder(int studyNo, int folderNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		ArrayList<StudyFolder> list = studyfolderMapper.selectlistOneStudyFolder(studyNo, folderNo);
		return list;
	}
	// studyFolder 생성
	public int insertStudyFolder(String folderName) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		int result = studyfolderMapper.insertStudyFolder(folderName);
		return result;
	}
	// studyFolder 삭제
	public int deleteStudyFolder(int folderNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		int result = studyfolderMapper.deleteStudyFolder(folderNo);
		return result;
	}
	
	// studyFolder 리스트 조회
	public ArrayList<StudyFolder> selectlist(int studyNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		ArrayList<StudyFolder> list = studyfolderMapper.selectlistStudyFolder(studyNo);
		return list;
	}
}
