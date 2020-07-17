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
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;

@Controller
public class StudyFolderController {

	@Autowired
	private StudyFolderService studyFolderService;

	// 스터디 파일공유 작성폼
	@RequestMapping("/studyfileShare")
	public ModelAndView studyfileShareForm(ModelAndView mv, HttpSession session) {
		Student student = (Student) session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();
		int studentNo = student.getsNo();
		String studentName = student.getsName();
		StudyFolder folder = studyFolderService.selectOneFolder(studyNo);
		ArrayList<StudyFolder> list = studyFolderService.selectlistFolder(studyNo, folder.getFolderNo());
		mv.addObject("folder", folder);
		mv.addObject("FolderList", list);
		mv.setViewName("study/studyfileShare");
		
		return mv;
	}

	// 스터디 파일공유페이지 상세보기
	@RequestMapping("/studyfileShareDetail")
	public ModelAndView studyfileShareMain(ModelAndView mv, HttpSession session) {
		Student student = (Student) session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();
		// parentfolder
		System.out.println(studyNo);
		StudyFolder folder = studyFolderService.selectOneFolder(studyNo);
		// parentfolder의 자식들을 배열로 만들어서 가져옴
		ArrayList<StudyFolder> list = studyFolderService.selectlistOneStudyFolder(studyNo, folder.getFolderNo());
		ArrayList<Student> slist = studyFolderService.selectstudentName(student.getsNo());
		System.out.println("student.getsNo : " + student.getsNo());
		String sfwriter = student.getsName();
		System.out.println("student.getsName : " + student.getsName());
		mv.addObject("fileWriter", sfwriter);
		mv.addObject("folder", folder);
		mv.addObject("childerenFolderList", list);
		mv.setViewName("study/studyfileShareDetail");
		return mv;
	}
	
	@RequestMapping("insertfolder.cunity")
	public String insertStudyFolder(String folderName, Model model) {
		/*
		 * Student student = (Student)session.getAttribute("loginStudent");
		 * student.getStudyNo()
		 */
		int result = 0;
		result = studyFolderService.insertStudyFolder(folderName);
		if (result > 0) {
			return "success";
		} else {
			model.addAttribute("msg", "폴더 생성 실패");
			return "study/studyfileShare";
		}

	}

}
