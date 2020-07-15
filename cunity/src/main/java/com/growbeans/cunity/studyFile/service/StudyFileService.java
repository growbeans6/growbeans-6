
package com.growbeans.cunity.studyFile.service;

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
	 * study 파일 다운로드를 위한 메소드
	 * 
	 * @param studyFile
	 * @return result
	 */
	public int downloadStudyFile(int fileNo);

	/**
	 * study 파일 삭제를 위한 메소드
	 * 
	 * @param fileNo
	 * @return result
	 */
	public int deleteStudyFile(int fileNo);
}
