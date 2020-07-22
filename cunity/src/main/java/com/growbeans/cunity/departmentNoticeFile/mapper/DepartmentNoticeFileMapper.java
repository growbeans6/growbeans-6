package com.growbeans.cunity.departmentNoticeFile.mapper;

import com.growbeans.cunity.departmentNoticeFile.domain.DepartmentNoticeFile;

public interface DepartmentNoticeFileMapper {

	DepartmentNoticeFile selectOnedNoticeFile(DepartmentNoticeFile dNoticeFile);
	
	int uploaddNoticeFile(DepartmentNoticeFile dNoticeFile);
	
	int downloaddNoticeFile(int dfileNo);
	
	int deletedNoticeFile(int dfileNo);
}
