package com.growbeans.cunity.studyFile.mapper;

import com.growbeans.cunity.studyFile.domain.StudyFile;

public interface StudyFileMapper {
	// 스터디 파일 하나 선택
	StudyFile selectOneStudyFile(int fileNo);

	// 스터디 파일 업로드
	int uploadStudyFile(StudyFile studyFile);

	// 스터디 파일 다운로드
	int downloadStudyFile(int fileNo);

	// 스터디 파일 삭제
	int deleteStudyFile(int fileNo);

}
