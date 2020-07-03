package com.growbeans.cunity.studyFolder.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.growbeans.cunity.studyFolder.service.logic.StudyFolderServiceImpl;

public class StudyFolderController {

	@Autowired
	private StudyFolderServiceImpl studyFolderService;

	// 스터디 폴더 생성
	public String insertStudyFolder() {
		return null;
	}

	// 스터디 폴더 삭제
	public String deleteStudyFolder() {
		return null;
	}
}
