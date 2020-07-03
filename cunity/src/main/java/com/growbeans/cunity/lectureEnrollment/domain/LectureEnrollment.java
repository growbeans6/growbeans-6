package com.growbeans.cunity.lectureEnrollment.domain;

import java.util.Date;

public class LectureEnrollment {


	private int lCode;
	private String sNo;
	
	public LectureEnrollment() {
		super();
	}
	public LectureEnrollment(int lCode, String sNo) {
		super();
		this.lCode = lCode;
		this.sNo = sNo;
	}
	public int getlCode() {
		return lCode;
	}
	public void setlCode(int lCode) {
		this.lCode = lCode;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	@Override
	public String toString() {
		return "LectureEnrollment [lCode=" + lCode + ", sNo=" + sNo + "]";
	} 
	
}
