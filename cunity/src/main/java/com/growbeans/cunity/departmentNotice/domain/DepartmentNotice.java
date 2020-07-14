package com.growbeans.cunity.departmentNotice.domain;

import java.util.Date;

public class DepartmentNotice {

	private int dnNo;
	private int pNo;
	private String dnTitle;
	private String dnContent;
	private Date dnDate;
	private String pName;
	
	
	public DepartmentNotice() {}

	public DepartmentNotice(int dnNo, int pNo, String dnTitle, String dnContent, Date dnDate, String pName) {
		super();
		this.dnNo = dnNo;
		this.pNo = pNo;
		this.dnTitle = dnTitle;
		this.dnContent = dnContent;
		this.dnDate = dnDate;
		this.pName = pName;
	}





	public int getDnNo() {
		return dnNo;
	}


	public void setDnNo(int dnNo) {
		this.dnNo = dnNo;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	public String getDnTitle() {
		return dnTitle;
	}


	public void setDnTitle(String dnTitle) {
		this.dnTitle = dnTitle;
	}


	public String getDnContent() {
		return dnContent;
	}


	public void setDnContent(String dnContent) {
		this.dnContent = dnContent;
	}


	public Date getDnDate() {
		return dnDate;
	}


	public void setDnDate(Date dnDate) {
		this.dnDate = dnDate;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "DepartmentNotice [dnNo=" + dnNo + ", pNo=" + pNo + ", dnTitle=" + dnTitle + ", dnContent=" + dnContent
				+ ", dnDate=" + dnDate + ", pName=" + pName + "]";
	}

}