package com.growbeans.cunity.studyFile.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.studyFile.domain.StudyFile;
import com.growbeans.cunity.studyFile.service.StudyFileService;

@Controller
public class StudyFileController {

	@Autowired
	private StudyFileService studyFileService;

	
	// 파일 등록
	@RequestMapping(value = "sfinsert.cunity", method = RequestMethod.POST)
	public String uploadStudyFile(StudyFile studyFile, Model model,
			@RequestParam(name = "uploadFile", required = true) MultipartFile uploadFile, HttpServletRequest request) {
		// 해당 파라미터 반드시 필수
		// required=true, NULL이면 입력시 400에러 발생

		// MultipartResolver -> Multipart형식으로 된 데이터가 전송된 경우
		// 해당 데이터를 스프링 MVC에서 사용할 수 있도록 변환시켜줌

		// 1. 파일을 서버에 저장 (넘어온 파일 저장)
		if (!uploadFile.getOriginalFilename().equals("")) {
			String filePath = saveFile(uploadFile, request);
			if (filePath != null) {
				studyFile.setFilePath(uploadFile.getOriginalFilename());
			}
		}

		// 2. 파일에 대한 데이터를 DB에 저장
		int result = 0;
		String path = null;
		// 컨트롤러에서 처리
		result = studyFileService.uploadStudyFile(studyFile);

		if (result > 0) {
			path = "study/studyfileShare";
		} else {
			model.addAttribute("msg", "파일 업로드 실패");
			path = "study/studyfileShare";
		}

		return path;
	}

	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
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
		return filePath;
	}

	/* public String downloadStudyFile(StudyFile studyFile, Model model, ) */

}
