package com.growbeans.cunity.studyFolder.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;

public interface StudyFolderMapper {

	// 스터디 폴더 하나 선택
	public StudyFolder selectOneStudyFolder(@Param("studyNo") int studyNo);

	// 스터디 폴더 리스트 조회
	public ArrayList<StudyFolder> selectlistStudyFolder(@Param("studyNo") int studyNo, @Param("folderNo") int folderNo);

	// 스터디 폴더 하나 생성
	public int insertStudyFolder(String folderName);

	// 스터디 폴더 하나 선택해서 내용 가져오기
	public ArrayList<StudyFolder> selectlistOneStudyFolder(@Param("studyNo") int studyNo, @Param("folderNo") int folderNo);

	// 스터디 폴더 하나 삭제
	public int deleteStudyFolder(int folderNo);
	
	// 특정 스터디 폴더의 파일 리스트들 불러오기
	public ArrayList<StudyFile> selectlistStudyFile(@Param("studyNo") int studyNo, @Param("folderNo") int folderNo);
}
