package com.growbeans.cunity.departmentNotice.domain;

import java.util.Date;

public class DepartmentNotice {

	private int dnNo;
	private int pNo;
	private String dnTitle;
	private Date dnDate;
	private String dnContent;

	private String filePath;
	
	
	public DepartmentNotice() {}

	public DepartmentNotice(int dnNo, int pNo, String dnTitle, Date dnDate, String dnContent, String filePath) {
		super();
		this.dnNo = dnNo;
		this.pNo = pNo;
		this.dnTitle = dnTitle;
		this.dnDate = dnDate;
		this.dnContent = dnContent;
		this.filePath = filePath;
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

	public Date getDnDate() {
		return dnDate;
	}

	public void setDnDate(Date dnDate) {
		this.dnDate = dnDate;
	}

	public String getDnContent() {
		return dnContent;
	}

	public void setDnContent(String dnContent) {
		this.dnContent = dnContent;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "DepartmentNotice [dnNo=" + dnNo + ", pNo=" + pNo + ", dnTitle=" + dnTitle + ", dnDate=" + dnDate
				+ ", dnContent=" + dnContent + ", filePath=" + filePath + "]";
	}

}
