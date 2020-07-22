package com.growbeans.cunity.studyFolder.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFolder.domain.StudyFolder;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;

@Controller
public class StudyFolderController {

	@Autowired
	private StudyFolderService studyFolderService;

	// 스터디 파일공유 페이지
	@RequestMapping("/studyfileShare")
	public ModelAndView studyfileShareForm(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		Student student = (Student) session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();

		/*StudyFolder folder = studyFolderService.selectOneFolder(studyNo);
		System.out.println(folder);
		ArrayList<StudyFolder> list = studyFolderService.selectlistFolder(studyNo, folder.getFolderNo());*/
		/*mv.addObject("folder", folder);
		mv.addObject("FolderList", list);*/
		mv.setViewName("study/studyfileShare");

		return mv;
	}

	// 스터디 파일공유페이지 상세보기
	@RequestMapping("/studyfileShareDetail")
	public ModelAndView studyfileShareMain(ModelAndView mv, @RequestParam("folderNo") int folderNo, HttpSession session, HttpServletRequest request) {
		Student student = (Student) session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();
		System.out.println(studyNo);
		// 한 폴더의 스터디 파일들 가져옴
		ArrayList<StudyFile> flist = studyFolderService.selectlistStudyFile(studyNo, folderNo);
		// 최상위 폴더에서 최상위 폴더의 자식 폴더들을 가져옴
		ArrayList<StudyFolder> folderList = studyFolderService.selectlistStudyFolder(folderNo);
		System.out.println(flist);
		System.out.println(folderList);
		mv.addObject("filelist", flist);
		mv.addObject("folderlist", folderList);
		mv.setViewName("study/studyfileShareDetail");
		return mv;
	}

	@RequestMapping(value = "insertfolder.cunity", method = RequestMethod.POST)
	public void insertStudyFolder(StudyFolder studyFolder, Model model, HttpServletResponse response)
			throws JsonIOException, IOException {
		studyFolderService.insertStudyFolder(studyFolder);
		// 데이터를 만들엇음!!!!!!
		// 만든 걸 불러오는 메소드
		StudyFolder newFolder = studyFolderService.newSelectOneStudyFolder();
		System.out.println(newFolder);
		// json구조를 띄는 직렬화된 데이터를 java의 객체로 역직렬화, 직렬화
		Gson gson = new GsonBuilder().create();
		// java객체를 json객체로 반환
		// {'folderNo' : 1, 'folderName' : '폴더1'}
		gson.toJson(newFolder, response.getWriter());

	}

}
