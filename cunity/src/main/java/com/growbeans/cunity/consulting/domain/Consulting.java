package com.growbeans.cunity.consulting.domain;

import java.util.Date;

public class Consulting {

	
	private int cNo;
	private int pNo;
	private int sNo;
	private String sName;
	private String cTitle;
	private String cContent;
	private String cAnswer;
	private Date cDate;
	private int sGrade;
	private int flag;
	private String pName;

	public Consulting() {}

	public Consulting(int cNo, int pNo, int sNo, String sName, String cTitle, String cContent, String cAnswer,
			Date cDate, int sGrade, int flag) {
		super();
		this.cNo = cNo;
		this.pNo = pNo;
		this.sNo = sNo;
		this.sName = sName;
		this.cTitle = cTitle;
		this.cContent = cContent;
		this.cAnswer = cAnswer;
		this.cDate = cDate;
		this.sGrade = sGrade;
		this.flag = flag;
	}

	
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getcNo() {
		return cNo;
	}



	public void setcNo(int cNo) {
		this.cNo = cNo;
	}



	public int getpNo() {
		return pNo;
	}



	public void setpNo(int pNo) {
		this.pNo = pNo;
	}



	public int getsNo() {
		return sNo;
	}



	public void setsNo(int sNo) {
		this.sNo = sNo;
	}



	public String getsName() {
		return sName;
	}



	public void setsName(String sName) {
		this.sName = sName;
	}



	public String getcTitle() {
		return cTitle;
	}



	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}



	public String getcContent() {
		return cContent;
	}



	public void setcContent(String cContent) {
		this.cContent = cContent;
	}



	public String getcAnswer() {
		return cAnswer;
	}



	public void setcAnswer(String cAnswer) {
		this.cAnswer = cAnswer;
	}



	public Date getcDate() {
		return cDate;
	}



	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}



	public int getsGrade() {
		return sGrade;
	}



	public void setsGrade(int sGrade) {
		this.sGrade = sGrade;
	}

	
	
}
