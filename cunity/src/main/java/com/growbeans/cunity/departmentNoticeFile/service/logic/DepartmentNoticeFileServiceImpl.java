package com.growbeans.cunity.departmentNoticeFile.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.departmentNoticeFile.domain.DepartmentNoticeFile;
import com.growbeans.cunity.departmentNoticeFile.service.DepartmentNoticeFileService;
import com.growbeans.cunity.departmentNoticeFile.store.DepartmentNoticeFileStoreLogic;

@Service("dNoticeFileService")
public class DepartmentNoticeFileServiceImpl implements DepartmentNoticeFileService{

	@Autowired
	private DepartmentNoticeFileStoreLogic dNoticeFileStore;
	
	@Override
	public int uploaddNoticeFile(DepartmentNoticeFile dNoticeFile) {
		return dNoticeFileStore.uploaddNoticeFile(dNoticeFile);
	}

	@Override
	public int downloaddNoticeFile(int dfileNo) {
		int result = dNoticeFileStore.downloaddNoticeFile(dfileNo);
		return result;
	}

	@Override
	public int deletedNoticeFile(int dfileNo) {
		int result = dNoticeFileStore.deletedNoticeFile(dfileNo);
		return result;
	}

}
