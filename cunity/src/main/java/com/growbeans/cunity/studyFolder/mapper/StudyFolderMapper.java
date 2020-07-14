package com.growbeans.cunity.studyFolder.mapper;

import java.util.ArrayList;
import java.util.List;

import com.growbeans.cunity.studyFolder.domain.StudyFolder;

public interface StudyFolderMapper {
	// 스터디 폴더 하나 선택
	public StudyFolder selectOneStudyFolder(int studyNo); 
	// 스터디 폴더 리스트 조회
	public ArrayList<StudyFolder> selectlistStudyFolder(int studyNo);
	// 스터디 폴더 하나 생성
	public int insertStudyFolder(String folderName);
	// 스터디 폴더 하나 선택해서 내용 가져오기
	public ArrayList<StudyFolder> selectlistOneStudyFolder(int studyNo);

	// 스터디 폴더 하나 삭제
	public int deleteStudyFolder(int folderNo);
}
