package com.growbeans.cunity.lectureEnrollment.domain;

import java.util.Date;

public class LectureEnrollment {


	private int lCode;
	private int sNo;
	private String sRate;
	public LectureEnrollment() {
		super();
	}
	

	public LectureEnrollment(int lCode, int sNo) {
		super();
		this.lCode = lCode;
		this.sNo = sNo;
	}

	public String getsRate() {
		return sRate;
	}


	public void setsRate(String sRate) {
		this.sRate = sRate;
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
