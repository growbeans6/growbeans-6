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
		return dStore.noticeList();
	}

	@Override
	public DepartmentNotice noticeDetail(int dnNo) {
		return dStore.noticeDetail(dnNo);
	}

	@Override
	public int noticeInsert(DepartmentNotice notice) {
		notice.setDnContent(notice.getDnContent().replace("\n", "<br>"));
		return dStore.noticeInsert(notice);
	}

	@Override
	public int noticeUpdate(DepartmentNotice notice) {
		notice.setDnContent(notice.getDnContent().replace("\n", "<br>"));
		return dStore.noticeUpdate(notice);
	}

	@Override
	public int noticeDelete(int dnNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
