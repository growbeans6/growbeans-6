package com.growbeans.cunity.lectureEnrollment.domain;

import java.util.Date;

public class LectureEnrollment {


	private int lCode;
	private int sNo;
	
	public LectureEnrollment() {
		super();
	}
	

	public LectureEnrollment(int lCode, int sNo) {
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

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	
	
}
