package com.growbeans.cunity.lectureEvaluation.domain;

import java.util.Date;

public class LectureEvaluation {

	private int sNo;
	private int lCode;
	private int eRate;
	private String eContent;
	private Date eDate;
	
	
	public LectureEvaluation() {}

	public LectureEvaluation(int sNo, int lCode, int eRate, String eContent, Date eDate) {
		super();
		this.sNo = sNo;
		this.lCode = lCode;
		this.eRate = eRate;
		this.eContent = eContent;
		this.eDate = eDate;
	}


	public int getsNo() {
		return sNo;
	}


	public void setsNo(int sNo) {
		this.sNo = sNo;
	}


	public int getlCode() {
		return lCode;
	}


	public void setlCode(int lCode) {
		this.lCode = lCode;
	}


	public int geteRate() {
		return eRate;
	}


	public void seteRate(int eRate) {
		this.eRate = eRate;
	}


	public String geteContent() {
		return eContent;
	}


	public void seteContent(String eContent) {
		this.eContent = eContent;
	}


	public Date geteDate() {
		return eDate;
	}


	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	
	
	
	
}
