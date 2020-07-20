package com.growbeans.cunity.studyFile.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.mapper.StudyFileMapper;
import com.growbeans.cunity.studyFolder.mapper.StudyFolderMapper;

@Repository("studyFileStore")
public class StudyFileStoreLogic {

	@Autowired
	private SqlSession sqlSession;

	
	
	/**
	 * study 파일 업로드를 위한 메소드
	 * 
	 * @param studyFile
	 * @return result
	 */
	public int uploadStudyFile(StudyFile studyFile) {
		StudyFileMapper studyfileMapper = sqlSession.getMapper(StudyFileMapper.class);
		return studyfileMapper.uploadStudyFile(studyFile);
	}


	/**
	 * study 파일 삭제를 위한 메소드
	 * 
	 * @param fileNo
	 * @return
	 */
	public int deleteStudyFile(int fileNo) {
		StudyFileMapper studyFileMapper = sqlSession.getMapper(StudyFileMapper.class);
		return studyFileMapper.deleteStudyFile(fileNo);
	}
	// 특정 studyFolder의 studyFile 리스트 불러오기
	public StudyFile selectOneStudyFile(int fileNo) {
		StudyFileMapper studyfileMapper = sqlSession.getMapper(StudyFileMapper.class);
		return studyfileMapper.selectOneStudyFile(fileNo);
	}
}
