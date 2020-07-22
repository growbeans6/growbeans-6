package com.growbeans.cunity.departmentNoticeFile.service;

import com.growbeans.cunity.departmentNoticeFile.domain.DepartmentNoticeFile;

public interface DepartmentNoticeFileService {

	public int uploaddNoticeFile(DepartmentNoticeFile dnFile);
	
	public int downloaddNoticeFile(int dfileNo);
	
	public int deletedNoticeFile(int dfileNo);
}
