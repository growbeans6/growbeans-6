package com.growbeans.cunity.departmentNotice.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;
import com.growbeans.cunity.departmentNotice.store.DepartmentNoticeStore;


@Repository("dStore")
public class DepartmentNoticeStoreLogic implements DepartmentNoticeStore {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public ArrayList<DepartmentNotice> noticeList() {
		return null;
	}

	@Override
	public DepartmentNotice noticeDetail(int dnNo) {
		return null;
	}

	@Override
	public int noticeInsert(DepartmentNotice notice) {
		return 0;
	}

	@Override
	public int noticeUpdate(DepartmentNotice notice, int dnNo) {
		return 0;
	}

	@Override
	public int noticeDelete(int dnNo) {
		return 0;
	}


}
