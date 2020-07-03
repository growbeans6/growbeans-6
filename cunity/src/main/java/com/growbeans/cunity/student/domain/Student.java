package com.growbeans.cunity.student.domain;

public class Student {

	private int sNo;
	private String sDept;
	private String sName;
	private String sPhone;
	private String sAddress;
	private String sEmail;
	private int sGrade;
	private String sFile;
	private int studyNo;
	private int pNo;
	
	
	public Student() {}
	
	
	public Student(int sNo, String sDept, String sName, String sPhone, String sAddress, String sEmail, int sGrade,
			String sFile, int studyNo, int pNo) {
		super();
		this.sNo = sNo;
		this.sDept = sDept;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sAddress = sAddress;
		this.sEmail = sEmail;
		this.sGrade = sGrade;
		this.sFile = sFile;
		this.studyNo = studyNo;
		this.pNo = pNo;
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


	public String getsPhone() {
		return sPhone;
	}


	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}


	public String getsAddress() {
		return sAddress;
	}


	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}


	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}


	public int getsGrade() {
		return sGrade;
	}


	public void setsGrade(int sGrade) {
		this.sGrade = sGrade;
	}


	public String getsFile() {
		return sFile;
	}


	public void setsFile(String sFile) {
		this.sFile = sFile;
	}


	public int getStudyNo() {
		return studyNo;
	}


	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	@Override
	public String toString() {
		return "Student [sNo=" + sNo + ", sDept=" + sDept + ", sName=" + sName + ", sPhone=" + sPhone + ", sAddress="
				+ sAddress + ", sEmail=" + sEmail + ", sGrade=" + sGrade + ", sFile=" + sFile + ", studyNo=" + studyNo
				+ ", pNo=" + pNo + "]";
	}
}
