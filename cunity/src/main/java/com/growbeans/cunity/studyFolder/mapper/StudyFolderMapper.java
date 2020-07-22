package com.growbeans.cunity.studyFolder.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;

public interface StudyFolderMapper {

	/**
	 * 
	 * @param studyNo
	 * @return
	 */
	// @Param으로 prarameterType을 대체(여기에 쓰는 이름을 변수에 지정해줌)
	// 스터디 최상위폴더(바탕화면, 부모폴더NO가 NULL인거)
	// 스터디 넘버는 세션에서 가져오고 여기에서만 사용
	 public StudyFolder topStudyFolder(@Param("studyNo") int studyNo);

	/**
	 * 폴더 하나 선택
	 * @param studyNo아님
	 *            폴더넘버가 매개변수여야 합니다.
	 * @return
	 */
	// 폴더 넘버 조회해서 하나 가져오기
	public StudyFolder selectOneStudyFolder(@Param("folderNo") int folderNo);

	/**
	 * 
	 * 
	 * @param folderNo
	 * @return
	 */
	// 스터디 폴더 리스트 조회()
	// @Param("folderNo")는 부모폴더의 넘버
	public ArrayList<StudyFolder> selectlistStudyFolder(@Param("folderNo") int folderNo);

	/**
	 * 
	 * @param studyFolder
	 * @return
	 */
	// 스터디 폴더 하나 생성
	public int insertStudyFolder(StudyFolder studyFolder);

	/**
	 * 
	 * @param folderNo
	 * @return
	 */
	// 스터디 폴더 하나 삭제
	public int deleteStudyFolder(@Param("folderNo") int folderNo);

	/**
	 * 
	 * @param studyNo
	 * @param folderNo
	 * @return
	 */
	// 특정 스터디 폴더의 파일 리스트들 불러오기
	public ArrayList<StudyFile> selectlistStudyFile(@Param("studyNo") int studyNo, @Param("folderNo") int folderNo);

	/**
	 * 자식 폴더로 지정해 주기 위해 사용
	 * 
	 * @return
	 */
	// 가장 최근 생성한 스터디 폴더 정보 불러오기
	public StudyFolder newSelectOneStudyFolder();
}
