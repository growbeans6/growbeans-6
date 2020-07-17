package com.growbeans.cunity.departmentNotice.store;


import java.util.ArrayList;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;

public interface DepartmentNoticeStore {
	
	
	 public ArrayList<DepartmentNotice> noticeList();
	   public DepartmentNotice noticeDetail(int dnNo);
	   public int noticeInsert(DepartmentNotice notice);
	   public int noticeUpdate(DepartmentNotice notice);
	   public int noticeDelete(int dnNo);


}
