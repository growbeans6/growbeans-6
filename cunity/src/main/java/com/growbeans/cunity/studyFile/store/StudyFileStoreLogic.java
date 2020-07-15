package com.growbeans.cunity.studyFile.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.mapper.StudyFileMapper;

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
		int result = studyfileMapper.uploadStudyFile(studyFile);
		return result;
	}

	/**
	 * study 파일 다운로드를 위한 메소드
	 * 
	 * @param studyFile
	 * @return result
	 */
	public int downloadStudyFile(int fileNo) {
		StudyFileMapper studyfileMapper = sqlSession.getMapper(StudyFileMapper.class);
		int result = studyfileMapper.downloadStudyFile(fileNo);
		return result;
	}

	/**
	 * study 파일 삭제를 위한 메소드
	 * 
	 * @param fileNo
	 * @return result
	 */
	public int deleteStudyFile(int fileNo) {
		StudyFileMapper studyFileMapper = sqlSession.getMapper(StudyFileMapper.class);
		int result = 0;
		return result;
	}
}
