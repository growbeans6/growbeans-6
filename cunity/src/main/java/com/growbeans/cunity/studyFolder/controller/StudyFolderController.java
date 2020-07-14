package com.growbeans.cunity.studyFolder.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;

@Controller
public class StudyFolderController {

	@Autowired
	private StudyFolderService studyFolderService;

	// 스터디 파일공유페이지
	@RequestMapping("/studyfileShare")
	public ModelAndView studyfileShareMain(ModelAndView mv, HttpSession session, String folderName ) {
		Student student = (Student)session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();
		// parentfolder 
		StudyFolder folder = studyFolderService.selectOneFolder(studyNo); 
		// parentfolder의 자식들을 배열로 만들어서 가져옴
		ArrayList<StudyFolder> list = studyFolderService.selectlistOneStudyFolder(studyNo);
		mv.addObject("folder", folder);
		mv.addObject("childerenFolderList", list);
		mv.setViewName("study/studyfileShare2");
		return mv;
	}

	@RequestMapping("/studyRoomMain")
	public String studyRoomMain() {
		return "study/studyRoom";
	}

	@RequestMapping("insertfolder.cunity")
	public String insertStudyFolder(String folderName, Model model) {
		/*Student student = (Student)session.getAttribute("loginStudent");
		student.getStudyNo()*/
		int result = 0;
		result = studyFolderService.insertStudyFolder(folderName);
		if (result > 0) {
			return "success";
		} else {
			model.addAttribute("msg", "폴더 생성 실패");
			return "study/studyfileShare";
		}

	}

	@RequestMapping(value="selectfolderList", method = RequestMethod.POST)
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
