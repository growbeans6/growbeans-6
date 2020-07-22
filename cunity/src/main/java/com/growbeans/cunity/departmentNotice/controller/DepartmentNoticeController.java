package com.growbeans.cunity.departmentNotice.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            mv.setViewName("professor/dNoticeList");
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
      public String noticeInsert(DepartmentNotice notice, Model model, HttpSession session,
    		  @RequestParam(name="uploadFile",required=false)MultipartFile uploadFile, HttpServletRequest request) {
         int dNoticeInsert = 0;
         String path = null;
         Professor professor = (Professor)session.getAttribute("loginprof");
         int pNo = professor.getpNo();
         notice.setpName(professor.getpName());
         notice.setpNo(pNo);
         
         if(!uploadFile.getOriginalFilename().equals("")) {
  		   String filePath = saveFile(uploadFile, request);
  		   
  		   if(filePath != null) {
  			   //실제 파일이름을 가져와서 filePath를 set한다.
  			   notice.setDnFilePath(uploadFile.getOriginalFilename());
  		   }
  	     }
         
         dNoticeInsert = dService.noticeInsert(notice, uploadFile, request);
         if(dNoticeInsert > 0) {
        	path = "redirect:/dNoticeList";
         } else {
            model.addAttribute("msg", "공지사항 등록 실패");
            path = "home";
         }
         return path;
      }
      
      
    //파일 저장 메소드
      public String saveFile(MultipartFile file, HttpServletRequest request) {
   	   // 파일 저장 경로 설정
   	String root = request.getSession().getServletContext().getRealPath("resources");
       String savePath = root + "\\dnuploadFiles";

       // 저장 폴더 선택
       File folder = new File(savePath);

       // 만약 폴더가 없을 경우 자동 생성
       if(!folder.exists()) {
          folder.mkdir(); 
       }
   	   
   	   String filePath = folder + "\\" + file.getOriginalFilename();
   	   
   	   try {
   		file.transferTo(new File(filePath));
   	} catch (IllegalStateException | IOException e) {
   		e.printStackTrace();
   	}
   	   return filePath;
      }

      
      // 학과공지 수정화면으로 넘기기
      @RequestMapping("/dNoticeUpdateView")
      public String noticeUpdateView(int dnNo, Model model) {
         model.addAttribute("dNotice", dService.noticeDetail(dnNo));
         return "professor/dNoticeUpdate";
      }
      
      // 학과공지 수정
      @RequestMapping(value="/dNoticeUpdate", method=RequestMethod.POST)
      public String noticeUpdate(DepartmentNotice notice, Model model,
    		  HttpServletRequest request, MultipartFile reloadFile) {
    	  
    	  	 // 새로 업로드된 파일이 있을 경우
	  		if (reloadFile != null && !reloadFile.isEmpty()) {
	  			// 기존 업로드된 파일이 있을 경우
	  			if (notice.getDnFilePath() != null) {
	  				//기존 파일 삭제
	  				deleteFile(notice.getDnFilePath(), request);
	  			}
		  		// 새로 업로드된 파일 저장
				String savePath = saveFile(reloadFile, request);
				// 새로 업로드된 파일이 잘 저장이 되었다면 디비 저장
				if (savePath != null) {
					notice.setDnFilePath(reloadFile.getOriginalFilename());
				}
			}
	  		
    	  // 수정하기
          int result = dService.noticeUpdate(notice);
         
          if(result > 0) {
        	  System.out.println(reloadFile);
             return "redirect:/dNoticeDetail?dnNo="+notice.getDnNo();
          } else {
        	  model.addAttribute("msg", "공지사항 수정 실패");
             return "home";
          }
      }
      
      //파일 삭제 메소드
      //학과공지글 등록 실패 또는 글 수정으로 업로드 파일이 변한 경우
      //저장되어있는 기존 파일 삭제
      public void deleteFile(String fileName, HttpServletRequest request) {
    	  //파일 저장 경로 설정
    	  String root = request.getSession().getServletContext().getRealPath("resources");
    	  String savePath = root + "\\dnuploadFiles";
    	  //삭제할 파일 경로 + 파일명
    	  File deleteFile = new File(savePath + "\\" + fileName);
    	  //해당 파일이 존재할 경우 삭제
    	  if (deleteFile.exists()) {
    		  deleteFile.delete();
    	  }
      }

      
      // 학과공지 삭제
      // 1. DB데이터 삭제
      // 2. DB데이터 삭제 성공 시 저장된 파일 삭제
      // 3. 삭제 후 학과공지 목록으로 redirect
      @RequestMapping("/dNoticeDelete")
      public String noticeDelete(int dnNo, Model model, HttpServletRequest request,
    		  RedirectAttributes rd) {
    	  
    	 //파일을 지우기 위해 dnNo 공지 조회
    	 DepartmentNotice notice = dService.noticeDetail(dnNo);
         int result = dService.noticeDelete(dnNo);
         if (result > 0) {
        	 if(notice.getDnFilePath() != null) {
        		 deleteFile(notice.getDnFilePath(), request);
        	 }
        	 rd.addFlashAttribute("msg", "공지글 삭제 성공");
            return "redirect:/dNoticeList";
         } else {
        	 model.addAttribute("msg", "공지글 삭제 실패");
            return "home";
         }
      }
}