package com.growbeans.cunity.grade.domain;

public class Grade {

	private int sNo;
	private String sDept;
	private String sName;
	private int smCode;
	private String smName;
	private int sSemester;
	private String sRate;
	private int sGradeYear;
	
	
	public Grade() {}

	
	public Grade(int sNo, String sDept, String sName, int smCode, String smName, int sSemester, String sRate,
			int sGradeYear) {
		super();
		this.sNo = sNo;
		this.sDept = sDept;
		this.sName = sName;
		this.smCode = smCode;
		this.smName = smName;
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

	public int getSmCode() {
		return smCode;
	}

	public void setSmCode(int smCode) {
		this.smCode = smCode;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
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

	@Override
	public String toString() {
		return "Grade [sNo=" + sNo + ", sDept=" + sDept + ", sName=" + sName + ", smCode=" + smCode + ", smName="
				+ smName + ", sSemester=" + sSemester + ", sRate=" + sRate + ", sGradeYear=" + sGradeYear + "]";
	}
}

