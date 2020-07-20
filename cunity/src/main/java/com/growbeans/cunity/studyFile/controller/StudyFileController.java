package com.growbeans.cunity.studyFile.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.service.StudyFileService;
import com.growbeans.cunity.studyFolder.service.StudyFolderService;

@Controller
public class StudyFileController {

	@Autowired
	private StudyFileService studyFileService;

	// 파일 등록
	@RequestMapping(value = "sfinsert.cunity", method = RequestMethod.POST)
	public String uploadStudyFile(@ModelAttribute StudyFile studyFile, Model model,
			@RequestParam(name = "fileName", required = true) MultipartFile fileName, HttpServletRequest request,
			HttpSession session) {

		// session에 저장된 sName을 writer에 저장
		Student student = (Student) session.getAttribute("loginStudent");
		String writer = (String) student.getsName();
		// 해당 파라미터 반드시 필수
		// required=true, NULL이면 입력시 400에러 발생

		// MultipartResolver -> Multipart형식으로 된 데이터가 전송된 경우
		// 해당 데이터를 스프링 MVC에서 사용할 수 있도록 변환시켜줌

		// 1. 파일을 서버에 저장 (넘어온 파일 저장)
		if (!fileName.getOriginalFilename().equals("")) {
			StudyFile saveFile = saveFile(fileName, request);
			studyFile.setUploadFile(saveFile.getUploadFile());
			studyFile.setFileRegistrant(writer);
			if (studyFile != null) {
				studyFile.setFilePath(fileName.getOriginalFilename());
			}
		}

		// 2. 파일에 대한 데이터를 DB에 저장
		int result = 0;
		String path = null;
		// 컨트롤러에서 처리
		result = studyFileService.uploadStudyFile(studyFile);

		if (result > 0) {
			path = "redirect:/studyfileShareDetail";
		} else {
			model.addAttribute("msg", "파일 업로드 실패");
			path = "study/studyfileShare";
		}

		return path;
	}

	// 파일 저장
	public StudyFile saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정 -> 루트의 경로를 추적하기 위해서 getServletContext() 사용
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "//nuploadFiles";
		// 저장 폴더 선택
		File folder = new File(savePath);

		// 만약 폴더가 없을 경우 자동 생성
		if (!folder.exists()) {
			folder.mkdir();
		}
		// 경로 리턴
		StudyFile studyFile = new StudyFile();

		String fileName = file.getOriginalFilename();
		String filePath = folder + "\\" + file.getOriginalFilename();

		// 실제로 저장
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studyFile.setUploadFile(fileName);
		studyFile.setFilePath(filePath);
		return studyFile;
	}

	// 파일 삭제 메소드
	// 저장 되어 있는 기존 파일 삭제
	public void deleteFile(String uploadFile, HttpServletRequest request) {
		// 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 삭제할 파일 경로 + 파일명
		File deleteFile = new File(root + "\\nuploadFiles" + "\\" + uploadFile);
		System.out.println(deleteFile);
		// 해당파일이 존재할 경우 삭제
		if (deleteFile.exists()) {
			deleteFile.delete();
		}
	}

	// 파일 삭제할 수 있는 폼
	@RequestMapping(value = "sfdelete.cunity", method = RequestMethod.GET)
	public String deleteStudyFile(Model model, @RequestParam("fileNo") int fileNo, HttpSession session,
			HttpServletRequest request, RedirectAttributes rd) {
		StudyFile studyfile = studyFileService.selectOneStudyFile(fileNo);
		model.addAttribute("fileNo", fileNo);
		System.out.println(fileNo);
		int result = studyFileService.deleteStudyFile(fileNo);
		// DB에 있는 값을 지움
		if (result > 0) {
			if (studyfile.getFilePath() != null) {
				deleteFile(studyfile.getFilePath(), request);
				rd.addFlashAttribute("msg", "파일 삭제 완료");

			}
		}

		return "study/studyfileShare";

	}
}
