package com.growbeans.cunity.departmentNoticeFile.domain;

import java.util.Date;

public class DepartmentNoticeFile {

	private int dfileNo;
	private int dnNo;
	private String dnfName;
	private String dnfRoot;
	private Date dnfCdate;
	
	
	public DepartmentNoticeFile() {}


	public DepartmentNoticeFile(int dfileNo, int dnNo, String dnfName, String dnfRoot, Date dnfCdate) {
		super();
		this.dfileNo = dfileNo;
		this.dnNo = dnNo;
		this.dnfName = dnfName;
		this.dnfRoot = dnfRoot;
		this.dnfCdate = dnfCdate;
	}


	public int getDfileNo() {
		return dfileNo;
	}


	public void setDfileNo(int dfileNo) {
		this.dfileNo = dfileNo;
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
		return "DepartmentNoticeFile [dfileNo=" + dfileNo + ", dnNo=" + dnNo + ", dnfName=" + dnfName + ", dnfRoot="
				+ dnfRoot + ", dnfCdate=" + dnfCdate + "]";
	}
}