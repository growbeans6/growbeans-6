package com.growbeans.cunity.foreignActivities.domain;

import java.util.Date;

public class ForeignActivities {

	
	private int actNo;
	private String sNo;
	private String sName;
	private Date actDate;
	private String actTitle;
	private String actContent;
	private String actPhoto;
	
	
	public ForeignActivities() {}


	public ForeignActivities(int actNo, String sNo, String sName, Date actDate, String actTitle, String actContent,
			String actPhoto) {
		super();
		this.actNo = actNo;
		this.sNo = sNo;
		this.sName = sName;
		this.actDate = actDate;
		this.actTitle = actTitle;
		this.actContent = actContent;
		this.actPhoto = actPhoto;
	}


	public int getActNo() {
		return actNo;
	}


	public void setActNo(int actNo) {
		this.actNo = actNo;
	}


	public String getsNo() {
		return sNo;
	}


	public void setsNo(String sNo) {
		this.sNo = sNo;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public Date getActDate() {
		return actDate;
	}


	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}


	public String getActTitle() {
		return actTitle;
	}


	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}


	public String getActContent() {
		return actContent;
	}


	public void setActContent(String actContent) {
		this.actContent = actContent;
	}


	public String getActPhoto() {
		return actPhoto;
	}


	public void setActPhoto(String actPhoto) {
		this.actPhoto = actPhoto;
	}


	@Override
	public String toString() {
		return "ForeignActivities [actNo=" + actNo + ", sNo=" + sNo + ", sName=" + sName + ", actDate=" + actDate
				+ ", actTitle=" + actTitle + ", actContent=" + actContent + ", actPhoto=" + actPhoto + "]";
	}
}