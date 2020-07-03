package com.growbeans.cunity.studyFile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.service.StudyFileService;

@Controller
public class StudyFileController {
	
	@Autowired
	private StudyFileService studyFileService;
	
	public String uploadStudyFile(StudyFile studyFile, Model model, String fileName, String filePath) {
		return null;
	}
	
	/*public String downloadStudyFile(StudyFile studyFile, Model model, )*/
	
}
