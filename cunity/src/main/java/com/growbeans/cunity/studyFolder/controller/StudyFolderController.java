package com.growbeans.cunity.studyFolder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;

@Controller
public class StudyFolderController {

	@Autowired
	private StudyFolderService studyFolderService;
	
	// 스터디 파일공유페이지
	@RequestMapping("/studyfileShare")
	public String studyfileShareMain() {
		return "study/studyfileShare";
	}

	@RequestMapping("/studyRoomMain")
	public String studyRoomMain() {
		return "study/studyRoom";
	}
	@RequestMapping("")
	public String insertStudyFolder(StudyFolder studyFolder, Model model, HttpServletRequest request) {
		int result = 0;
		result = studyFolderService.insertStudyFolder(studyFolder, request);
		if ( result > 0 ) {
			return "study/studyfileShare";
		} else {
			model.addAttribute("msg", "폴더 생성 실패");
			return "study/studyfileShare";
		}
		
	}
}
