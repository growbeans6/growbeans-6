package com.growbeans.cunity.departmentNoticeFile.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.departmentNoticeFile.domain.DepartmentNoticeFile;
import com.growbeans.cunity.departmentNoticeFile.mapper.DepartmentNoticeFileMapper;

@Repository("dNoticeFileStore")
public class DepartmentNoticeFileStoreLogic {

	@Autowired SqlSession sqlSession;
	
	public int uploaddNoticeFile(DepartmentNoticeFile dNoticeFile) {
		DepartmentNoticeFileMapper dNoticeFileMapper = sqlSession.getMapper(DepartmentNoticeFileMapper.class);
		return dNoticeFileMapper.uploaddNoticeFile(dNoticeFile);
	}
	
	public int downloaddNoticeFile(int dfileNo) {
		DepartmentNoticeFileMapper dNoticeFileMapper = sqlSession.getMapper(DepartmentNoticeFileMapper.class);
		int result = dNoticeFileMapper.downloaddNoticeFile(dfileNo);
		return result;
	}
	
	public int deletedNoticeFile(int dfileNo) {
		DepartmentNoticeFileMapper dNoticeFileMapper = sqlSession.getMapper(DepartmentNoticeFileMapper.class);
		int result = 0;
		return result;
	}
}
