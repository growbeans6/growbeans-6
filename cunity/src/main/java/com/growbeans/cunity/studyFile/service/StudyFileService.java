
package com.growbeans.cunity.studyFile.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.studyFile.domain.StudyFile;

public interface StudyFileService {

	/**
	 * study 파일 업로드를 위한 메소드
	 * 
	 * @param studyFile
	 * @return result
	 */
	public int uploadStudyFile(StudyFile studyFile);

	/**
	 * study 파일 삭제를 위한 메소드
	 * 
	 * @param fileNo
	 * @return result
	 */
	public int deleteStudyFile(int fileNo);
	
	/**
	 * 특정 studyFolder에 하나의 studyfile을 불러오는 메소드
	 * 
	 * @param fileNo
	 * @return
	 */

	public StudyFile selectOneStudyFile(int fileNo);
}
