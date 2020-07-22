package com.growbeans.cunity.departmentNoticeFile.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.departmentNoticeFile.domain.DepartmentNoticeFile;
import com.growbeans.cunity.departmentNoticeFile.service.DepartmentNoticeFileService;

@Controller
public class DepartmentNoticeFileController {

	@Autowired
	private DepartmentNoticeFileService dNoticeFileService;
	
	//파일등록
	public String uploaddNoticeFile(DepartmentNoticeFile dNoticeFile, Model model,
			@RequestParam(name = "uploadFile", required = true) MultipartFile fileName,
			HttpServletRequest request) {
		
		if (!fileName.getOriginalFilename().equals("")) {
			DepartmentNoticeFile saveFile = saveFile(fileName, request);
			dNoticeFile.setDnfName(saveFile.getDnfName());
			if (dNoticeFile != null) {
				dNoticeFile.setDnfRoot(fileName.getOriginalFilename());
			}
		}
		
		//파일에 대한 데이터를 DB에 저장
		int result = 0;
		String path = null;
		//컨트롤러에서 처리
		result = dNoticeFileService.uploaddNoticeFile(dNoticeFile);
		
		if (result > 0) {
			path = "redirect:/dNoticeList";
		} else {
			model.addAttribute("msg", "학과공지 등록 실패");
			path = "home";
		}
		return path;
	}
	
	
	// 파일저장
	public DepartmentNoticeFile saveFile(MultipartFile file,
			HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "//dnuploadFiles";
		//저장폴더 선택
		File folder = new File(savePath);
		
		//만약 폴더가 없을 경우 자동 생성
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		//경로 리턴
		DepartmentNoticeFile dNoticeFile = new DepartmentNoticeFile();
		
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
		dNoticeFile.setDnfName(fileName);
		dNoticeFile.setDnfRoot(filePath);
		return dNoticeFile;
	}
}
