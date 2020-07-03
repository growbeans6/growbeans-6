package com.growbeans.cunity.Alarm.domain;

import java.sql.Date;

public class Alarm {

	private int aNo;
	private int sNo;
	private String aContent;
	private Date aTime;
	
	public Alarm() {}

	public Alarm(int aNo, int sNo, String aContent, Date aTime) {
		super();
		this.aNo = aNo;
		this.sNo = sNo;
		this.aContent = aContent;
		this.aTime = aTime;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public Date getaTime() {
		return aTime;
	}

	public void setaTime(Date aTime) {
		this.aTime = aTime;
	}

	@Override
	public String toString() {
		return "Alarm [aNo=" + aNo + ", sNo=" + sNo + ", aContent=" + aContent + ", aTime=" + aTime + "]";
	}
	
	
}
