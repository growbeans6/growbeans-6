package com.growbeans.cunity.departmentNotice.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;
import com.growbeans.cunity.departmentNotice.service.DepartmentNoticeService;

@Controller
public class DepartmentNoticeController {
	
	@Autowired
	   private DepartmentNoticeService nService;
	   
	   // 학과공지 조회
	   public ModelAndView noticeList(ModelAndView mv) {
	      return mv;
	   }
	   
	   // 학과공지 상세조회
	   public ModelAndView noticeDetail(ModelAndView mv, int dnNo) {
	      return mv;
	   }
	   
	   // 학과공지 작성 (작성할 때 파일생각)
	   public ModelAndView noticeInsert(DepartmentNotice notice, ModelAndView mv, @RequestParam(name="uploadFile",required=false)MultipartFile uploadFile, HttpServletRequest request) {
	      return null;
	   }

	   
	   // 학과공지 수정
	   public ModelAndView noticeUpdate(DepartmentNotice notice, int dnNo, ModelAndView mv, HttpServletRequest request, MultipartFile reloadFile) {
	      return null;
	   }

	   
	   // 학과공지 삭제
	   public String noticeDelete(int dnNo) {
	      return null;
	   }
	   
	   //파일 저장 메소드
	      public String saveFile(MultipartFile file, HttpServletRequest request) {
	         // 파일 저장 경로 설정
	      String root = request.getSession().getServletContext().getRealPath("resources");
	       String savePath = root + "\\nuploadFiles";

	       // 저장 폴더 선택
	       File folder = new File(savePath);

	       // 만약 폴더가 없을 경우 자동 생성
	       if(!folder.exists()) {
	          folder.mkdir(); 
	       }
	         
	         String filePath = folder + "\\" + file.getOriginalFilename();
	         
	        /* try {
	         file.transferTo(new File(filePath));
	      } catch (IllegalStateException | IOException e) {
	         e.printStackTrace();
	      }*/
	         return filePath;
	      }


}
