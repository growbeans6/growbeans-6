package com.growbeans.cunity.lecture.domain;

import java.util.Date;

public class Lecture {

	
	private int lcode;
	private int pNo;
	private String lName;
	private String lpName;
	private int lNumberStudent;
	private String lroom;
	private String lClassify;
	private int lPoint;
	private String lTime;
	private String lSemester;
	
	
	public Lecture() {}

	public Lecture(int lcode, int pNo, String lName, String lpName, int lNumberStudent, String lroom, String lClassify,
			int lPoint, String lTime, String lSemester) {
		super();
		this.lcode = lcode;
		this.pNo = pNo;
		this.lName = lName;
		this.lpName = lpName;
		this.lNumberStudent = lNumberStudent;
		this.lroom = lroom;
		this.lClassify = lClassify;
		this.lPoint = lPoint;
		this.lTime = lTime;
		this.lSemester = lSemester;
	}



	public int getLcode() {
		return lcode;
	}


	public void setLcode(int lcode) {
		this.lcode = lcode;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getLpName() {
		return lpName;
	}


	public void setLpName(String lpName) {
		this.lpName = lpName;
	}


	public int getlNumberStudent() {
		return lNumberStudent;
	}


	public void setlNumberStudent(int lNumberStudent) {
		this.lNumberStudent = lNumberStudent;
	}


	public String getLroom() {
		return lroom;
	}


	public void setLroom(String lroom) {
		this.lroom = lroom;
	}


	public String getlClassify() {
		return lClassify;
	}


	public void setlClassify(String lClassify) {
		this.lClassify = lClassify;
	}


	public int getlPoint() {
		return lPoint;
	}


	public void setlPoint(int lPoint) {
		this.lPoint = lPoint;
	}


	public String getlTime() {
		return lTime;
	}


	public void setlTime(String lTime) {
		this.lTime = lTime;
	}


	public String getlSemester() {
		return lSemester;
	}


	public void setlSemester(String lSemester) {
		this.lSemester = lSemester;
	}

	
	
}
