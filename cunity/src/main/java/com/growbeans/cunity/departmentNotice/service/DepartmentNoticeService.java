package com.growbeans.cunity.departmentNotice.service;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;

public interface DepartmentNoticeService {
	
	   
	public ArrayList<DepartmentNotice> noticeList();
	   public DepartmentNotice noticeDetail(int dnNo);
	   public int noticeInsert(DepartmentNotice notice);
	   public int noticeUpdate(DepartmentNotice notice);
	   public int noticeDelete(int dnNo);


}
