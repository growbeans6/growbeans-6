package com.growbeans.cunity.studyFolder.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.mapper.StudyFileMapper;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.mapper.StudyFolderMapper;

@Repository("studyFolderStore")
public class StudyFolderStoreLogic {

	@Autowired
	private SqlSession sqlsession;

	// 스터디 최상위폴더(바탕화면, 부모폴더NO가 NULL인거)
	public StudyFolder topStudyFolder(int studyNo) {
		StudyFolderMapper studyFolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		return studyFolderMapper.topStudyFolder(studyNo);
	}

	// studyFolder 하나 선택
	public StudyFolder selectOneStudyFolder(int folderNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		return studyfolderMapper.selectOneStudyFolder(folderNo);
	}

	// studyFolder 생성
	public int insertStudyFolder(StudyFolder studyFolder) {
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

	// studyFolder 리스트 조회
	public ArrayList<StudyFolder> selectlistStudyFolder(int folderNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		ArrayList<StudyFolder> list = studyfolderMapper.selectlistStudyFolder(folderNo);
		return list;
	}

	// 특정 studyFolder의 studyFile 리스트 불러오기
	public ArrayList<StudyFile> selectlistStudyFile(int studyNo, int folderNo) {
		StudyFolderMapper studyfolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		ArrayList<StudyFile> list = studyfolderMapper.selectlistStudyFile(studyNo, folderNo);
		return list;
	}

	// 최근 생성한 studyFolder 정보 불러오기
	public StudyFolder newSelectOneStudyFolder() {
		StudyFolderMapper studyFolderMapper = sqlsession.getMapper(StudyFolderMapper.class);
		return studyFolderMapper.newSelectOneStudyFolder();
	}
}
