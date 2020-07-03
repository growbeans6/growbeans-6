package com.growbeans.cunity.departmentNotice.service.logic;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;
import com.growbeans.cunity.departmentNotice.service.DepartmentNoticeService;
import com.growbeans.cunity.departmentNotice.store.DepartmentNoticeStore;


@Service("dService")
public class DepartmentNoticeImpl implements DepartmentNoticeService{
	
	@Autowired
	private DepartmentNoticeStore dStore;

	@Override
	public ArrayList<DepartmentNotice> noticeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentNotice noticeDetail(int dnNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int noticeInsert(DepartmentNotice notice, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeUpdate(DepartmentNotice notice, int dnNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeDelete(int dnNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
