package com.growbeans.cunity.departmentNoticeFile.domain;

import java.util.Date;

public class DepartmentNoticeFile {

	private int fileNo;
	private int dnNo;
	private String dnfName;
	private String dnfRoot;
	private Date dnfCdate;
	
	
	public DepartmentNoticeFile() {}
	

	public DepartmentNoticeFile(int fileNo, int dnNo, String dnfName, String dnfRoot, Date dnfCdate) {
		super();
		this.fileNo = fileNo;
		this.dnNo = dnNo;
		this.dnfName = dnfName;
		this.dnfRoot = dnfRoot;
		this.dnfCdate = dnfCdate;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getDnNo() {
		return dnNo;
	}

	public void setDnNo(int dnNo) {
		this.dnNo = dnNo;
	}

	public String getDnfName() {
		return dnfName;
	}

	public void setDnfName(String dnfName) {
		this.dnfName = dnfName;
	}

	public String getDnfRoot() {
		return dnfRoot;
	}

	public void setDnfRoot(String dnfRoot) {
		this.dnfRoot = dnfRoot;
	}

	public Date getDnfCdate() {
		return dnfCdate;
	}

	public void setDnfCdate(Date dnfCdate) {
		this.dnfCdate = dnfCdate;
	}

	@Override
	public String toString() {
		return "DepartmentNoticeFile [fileNo=" + fileNo + ", dnNo=" + dnNo + ", dnfName=" + dnfName + ", dnfRoot="
				+ dnfRoot + ", dnfCdate=" + dnfCdate + "]";
	}
	
	
	
}
