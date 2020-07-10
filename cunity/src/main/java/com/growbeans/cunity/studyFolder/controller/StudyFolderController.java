package com.growbeans.cunity.studyFolder.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;

@Controller
public class StudyFolderController {

	@Autowired
	private StudyFolderService studyFolderService;

	// 스터디 파일공유페이지
	@RequestMapping("/studyfileShare")
	public String studyfileShareMain() {
		return "study/studyfileShare2";
	}

	@RequestMapping("/studyRoomMain")
	public String studyRoomMain() {
		return "study/studyRoom";
	}

	@RequestMapping("/insertFolder")
	public String insertStudyFolder(StudyFolder studyFolder, Model model) {
		int result = 0;
		result = studyFolderService.insertStudyFolder(studyFolder);
		if (result > 0) {
			return "study/studyfileShare";
		} else {
			model.addAttribute("msg", "폴더 생성 실패");
			return "study/studyfileShare";
		}

	}

	@RequestMapping("/selectfolderList")
	public ModelAndView selectlistFolder(ModelAndView mv, int studyNo) {
		ArrayList<StudyFolder> list = studyFolderService.selectlistFolder(studyNo);

		if (!list.isEmpty()) {
			mv.addObject("list", list);
			mv.setViewName("study/studyfileShare");
		} else {
			mv.addObject("msg", "폴더 조회 실패");

		}
		return mv;
	}
}
