package com.growbeans.cunity.studyFile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.service.StudyFileService;

@Controller
public class StudyFileController {

	@Autowired
	private StudyFileService studyFileService;

	// 스터디 파일 공유 페이지 보기
	public ModelAndView studyFileShare() {
		return null;
	}

	// 스터디 파일 업로드
	public String uploadStudyFile() {
		return null;
	}

	// 스터디 파일 다운로드
	public String downloadStudyFile() {
		return null;
	}

	// 스터디 파일 삭제
	public String deleteStudyFile() {
		return null;
	}

}
