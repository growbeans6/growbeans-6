package com.growbeans.cunity.studyFolder.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;

public interface StudyFolderService {

	/**
	 * 스터디 최상위폴더(바탕화면, 부모폴더NO가 NULL인거)
	 * 
	 * @param studyNo
	 * @return
	 */

	public StudyFolder topStudyFolder(int studyNo);

	/**
	 * studyFolder를 생성하기 위한 메소드
	 * 
	 * @param studyFolder
	 * @return result
	 */
	public int insertStudyFolder(StudyFolder studyFolder);

	/**
	 * studyFolder를 삭제하기 위한 메소드
	 * 
	 * @param folderNo
	 * @return result
	 */
	public int deleteStudyFolder(int folderNo);

	/**
	 * studyFolderList를 조회하기 위한 메소드
	 * 
	 * @param folderNo
	 * @return list
	 */
	public ArrayList<StudyFolder> selectlistStudyFolder(int folderNo);

	/**
	 * studyFolder 하나를 조회해서 내용을 가져오는 메소드
	 * 
	 * @param folderNo
	 * @return
	 */
	public StudyFolder selectOneStudyFolder(int folderNo);

	/**
	 * 특정 studyFolder에 studyfile들을 불러오는 메소드
	 * 
	 * @param studyNo
	 * @param folderNo
	 * @return
	 */

	public ArrayList<StudyFile> selectlistStudyFile(int studyNo, int folderNo);

	/**
	 * 최근 생성한 폴더의 정보 내용 불러오는 메소드
	 * 
	 * 
	 * @return newFolder
	 */
	public StudyFolder newSelectOneStudyFolder();
}
