package com.growbeans.cunity.lecturesyllabus.domain;

public class LectureSyllabus {

	private int lCode;
	private String lsGoal;
	private String lsContent;
	private String lsBook;
	private String lsDate;
	
	
	public LectureSyllabus() {}
	

	public LectureSyllabus(int lCode, String lsGoal, String lsContent, String lsBook, String lsDate) {
		super();
		this.lCode = lCode;
		this.lsGoal = lsGoal;
		this.lsContent = lsContent;
		this.lsBook = lsBook;
		this.lsDate = lsDate;
	}


	public int getlCode() {
		return lCode;
	}


	public void setlCode(int lCode) {
		this.lCode = lCode;
	}


	public String getLsGoal() {
		return lsGoal;
	}


	public void setLsGoal(String lsGoal) {
		this.lsGoal = lsGoal;
	}


	public String getLsContent() {
		return lsContent;
	}


	public void setLsContent(String lsContent) {
		this.lsContent = lsContent;
	}


	public String getLsBook() {
		return lsBook;
	}


	public void setLsBook(String lsBook) {
		this.lsBook = lsBook;
	}


	public String getLsDate() {
		return lsDate;
	}


	public void setLsDate(String lsDate) {
		this.lsDate = lsDate;
	}


	@Override
	public String toString() {
		return "LectureSyllabus [lCode=" + lCode + ", lsGoal=" + lsGoal + ", lsContent=" + lsContent + ", lsBook="
				+ lsBook + ", lsDate=" + lsDate + "]";
	}
}
