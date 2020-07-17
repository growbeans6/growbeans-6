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
      return (ArrayList)sqlsession.selectList("dNoticeMapper.selectdnList");
   }

   @Override
   public DepartmentNotice noticeDetail(int dnNo) {
      return sqlsession.selectOne("dNoticeMapper.selectdnOne", dnNo);
   }

   @Override
   public int noticeInsert(DepartmentNotice notice) {
      return sqlsession.insert("dNoticeMapper.insertdNotice", notice);
   }

   @Override
   public int noticeUpdate(DepartmentNotice notice) {
      return sqlsession.update("dNoticeMapper.updatedNotice", notice);
   }

   @Override
   public int noticeDelete(int dnNo) {
      return sqlsession.delete("dNoticeMapper.deletedNotice", dnNo);
   }


}