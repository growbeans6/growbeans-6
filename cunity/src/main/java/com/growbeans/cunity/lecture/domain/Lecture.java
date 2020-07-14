package com.growbeans.cunity.lecture.domain;

import java.util.Date;

public class Lecture {

	
	private int lcode;
	private int pNo;
	private String lName;
	private String lDay1;
	private int lStartTime1;
	private int lEndTime1;
	private String lDay2;
	private int lStartTime2;
	private int lEndTime2;
	private String lpName;
	private int lNumberStudent;
	private String lroom;
	private String lClassify;
	private int lPoint;
	private String lTime;
	private String lSemester;
	
	
	public Lecture() {}


	public Lecture(int lcode, int pNo, String lName, String lDay1, int lStartTime1, int lEndTime1, String lDay2,
			int lStartTime2, int lEndTime2, String lpName, int lNumberStudent, String lroom, String lClassify,
			int lPoint, String lTime, String lSemester) {
		super();
		this.lcode = lcode;
		this.pNo = pNo;
		this.lName = lName;
		this.lDay1 = lDay1;
		this.lStartTime1 = lStartTime1;
		this.lEndTime1 = lEndTime1;
		this.lDay2 = lDay2;
		this.lStartTime2 = lStartTime2;
		this.lEndTime2 = lEndTime2;
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


	public String getlDay1() {
		return lDay1;
	}


	public void setlDay1(String lDay1) {
		this.lDay1 = lDay1;
	}


	public int getlStartTime1() {
		return lStartTime1;
	}


	public void setlStartTime1(int lStartTime1) {
		this.lStartTime1 = lStartTime1;
	}


	public int getlEndTime1() {
		return lEndTime1;
	}


	public void setlEndTime1(int lEndTime1) {
		this.lEndTime1 = lEndTime1;
	}


	public String getlDay2() {
		return lDay2;
	}


	public void setlDay2(String lDay2) {
		this.lDay2 = lDay2;
	}


	public int getlStartTime2() {
		return lStartTime2;
	}


	public void setlStartTime2(int lStartTime2) {
		this.lStartTime2 = lStartTime2;
	}


	public int getlEndTime2() {
		return lEndTime2;
	}


	public void setlEndTime2(int lEndTime2) {
		this.lEndTime2 = lEndTime2;
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
