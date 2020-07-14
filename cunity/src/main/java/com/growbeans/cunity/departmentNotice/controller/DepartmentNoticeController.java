package com.growbeans.cunity.departmentNotice.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;
import com.growbeans.cunity.departmentNotice.service.DepartmentNoticeService;
import com.growbeans.cunity.professor.domain.Professor;

@Controller
public class DepartmentNoticeController {
	
	@Autowired
	   private DepartmentNoticeService dService;
	   
	// 학과공지 조회
	@RequestMapping(value="/dNoticeList", method=RequestMethod.GET)
	   public ModelAndView noticeList(ModelAndView mv) {
			ArrayList<DepartmentNotice> dnlist = dService.noticeList();
			
			if (!dnlist.isEmpty()) {
				mv.addObject("dnlist", dnlist);
				mv.setViewName("professor/dNoticeList");
			} else {
				mv.addObject("msg", "공지사항 목록 조회 실패");
				mv.setViewName("home");
			}
	      return mv;
	   }
	   
	   // 학과공지 상세조회
	   @RequestMapping("/dNoticeDetail")
	   public String noticeDetail(Model model, int dnNo) {
		   DepartmentNotice dnDetail = dService.noticeDetail(dnNo);
		   if (dnDetail != null) {
			   model.addAttribute("dnDetail", dnDetail);
			   return "professor/dNoticeDetail";
		   } else {
			   model.addAttribute("msg", "학과공지 상세조회 실패");
			   return "home";
		   }
	   }
	   
	   // 학과공지 등록화면으로 넘기기
	   @RequestMapping("/dNoticeInsertView")
	   public String dNoticeInsertView() {
		   return "professor/dNoticeInsert";
	   }
	   
	   // 학과공지 작성 (작성할 때 파일생각)
	   @RequestMapping(value="/dNoticeInsert", method=RequestMethod.POST)
	   public ModelAndView noticeInsert(DepartmentNotice notice, ModelAndView mv, HttpSession session) {
		   int dNoticeInsert = 0;
		   Professor professor = (Professor)session.getAttribute("loginprof");
		   int pNo = professor.getpNo();
		   notice.setpName(professor.getpName());
		   notice.setpNo(pNo);
		   dNoticeInsert = dService.noticeInsert(notice);
		   if(dNoticeInsert > 0) {
			   System.out.println(dNoticeInsert);
			   mv.addObject("dNoticeInsert",dNoticeInsert);
			   mv.setViewName("redirect:/dNoticeList");
		   } else {
			   mv.setViewName("home");
		   }
	      return mv;
	   }

	   
	   // 학과공지 수정화면으로 넘기기
	   @RequestMapping("/dNoticeUpdateView")
	   public String noticeUpdateView(int dnNo, Model model) {
		   model.addAttribute("dNotice", dService.noticeDetail(dnNo));
		   return "professor/dNoticeUpdate";
	   }
	   // 학과공지 수정
	   @RequestMapping(value="dNoticeUpdate")
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
