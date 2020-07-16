package com.growbeans.cunity.grade.domain;

public class Grade {

	private int sNo;
	private String sDept;
	private String sName;
	private int lCode;
	private String lName;
	private int sSemester;
	private String sRate;
	private int sGradeYear;
	
	
	public Grade() {}

	public Grade(int sNo, String sDept, String sName, int lCode, String lName, int sSemester, String sRate,
			int sGradeYear) {
		super();
		this.sNo = sNo;
		this.sDept = sDept;
		this.sName = sName;
		this.lCode = lCode;
		this.lName = lName;
		this.sSemester = sSemester;
		this.sRate = sRate;
		this.sGradeYear = sGradeYear;
	}


	public int getsNo() {
		return sNo;
	}


	public void setsNo(int sNo) {
		this.sNo = sNo;
	}


	public String getsDept() {
		return sDept;
	}


	public void setsDept(String sDept) {
		this.sDept = sDept;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public int getlCode() {
		return lCode;
	}


	public void setlCode(int lCode) {
		this.lCode = lCode;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public int getsSemester() {
		return sSemester;
	}


	public void setsSemester(int sSemester) {
		this.sSemester = sSemester;
	}


	public String getsRate() {
		return sRate;
	}


	public void setsRate(String sRate) {
		this.sRate = sRate;
	}


	public int getsGradeYear() {
		return sGradeYear;
	}


	public void setsGradeYear(int sGradeYear) {
		this.sGradeYear = sGradeYear;
	}

	
	
}

