package com.growbeans.cunity.studyFolder.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	// 스터디 파일공유페이지 메인
	@RequestMapping(value = "/studyfileShareMain", method = RequestMethod.GET)

	public ModelAndView studyfileShareMain(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		Student student = (Student) session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();
		// 최상위 폴더 보여주기
		StudyFolder studyfolder = studyFolderService.topStudyFolder(studyNo);
		System.out.println(studyfolder);

		// 한 폴더의 스터디 파일들 가져옴
		ArrayList<StudyFile> flist = studyFolderService.selectlistStudyFile(studyNo, studyfolder.getFolderNo());
		// 최상위 폴더에서 최상위 폴더의 자식 폴더들을 가져옴
		ArrayList<StudyFolder> folderList = studyFolderService.selectlistStudyFolder(studyNo,
				studyfolder.getFolderNo());
		System.out.println(flist);
		System.out.println(folderList);
		mv.addObject("folder", studyfolder);
		mv.addObject("filelist", flist);
		mv.addObject("folderlist", folderList);
		mv.setViewName("study/studyfileShareMain");
		return mv;
	}

	// 스터디 파일공유페이지 상세보기
	@RequestMapping(value = "/forderDetail", method = RequestMethod.GET)
	public String studyFolderDetail(Model mo, int folderNo, HttpSession session) {
		StudyFolder studyFolder = studyFolderService.selectOneStudyFolder(folderNo);
		Student student = (Student) session.getAttribute("loginStudent");
		int studyNo = student.getStudyNo();
		// 한 폴더의 스터디 파일들 가져옴
		ArrayList<StudyFile> flist = studyFolderService.selectlistStudyFile(studyNo, studyFolder.getFolderNo());
		// 최상위 폴더에서 최상위 폴더의 자식 폴더들을 가져옴
		ArrayList<StudyFolder> folderList = studyFolderService.selectlistStudyFolder(studyNo,
				studyFolder.getFolderNo());
		mo.addAttribute("studyFolder", studyFolder);
		mo.addAttribute("filelist", flist);
		mo.addAttribute("folderlist", folderList);
		return "study/studyfileShareDetail";
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

	// 특정 폴더 삭제하기

	@RequestMapping("deleteFolder.cunity")
	public String deleteStudyFolder(int folderNo, Model model,  HttpSession session,
			HttpServletRequest request) {
		Student student = (Student) session.getAttribute("loginStudent");
		/*int studyNo = student.getStudyNo(); // folderNo 조회
*/		
		
//		StudyFolder studyFolder = studyFolderService.selectOneStudyFolder(folderNo); // studyfilelist 조회
		int result = studyFolderService.deleteStudyFolder(folderNo); // DB에 있는 값을 지움
		
		/*ArrayList<StudyFile> studyFile = studyFolderService.selectlistStudyFile(studyNo, studyFolder.getFolderNo());*/
		
		if (result > 0) {
			return "redirect:/studyfileShareMain";
		} else {
			return "study/studyfileShareDetail";
		}
		
	}

}
