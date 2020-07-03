package com.growbeans.cunity.friends.domain;

public class Friends {

	int fNo;
	String sNo;
	String sessionSNo;
	
	public Friends() {}

	public Friends(int fNo, String sNo, String sessionSNo) {
		super();
		this.fNo = fNo;
		this.sNo = sNo;
		this.sessionSNo = sessionSNo;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getSessionSNo() {
		return sessionSNo;
	}

	public void setSessionSNo(String sessionSNo) {
		this.sessionSNo = sessionSNo;
	}

	@Override
	public String toString() {
		return "Friends [fNo=" + fNo + ", sNo=" + sNo + ", sessionSNo=" + sessionSNo + "]";
	}
	
	
}
