package com.growbeans.cunity.friends.domain;

public class Friends {

	private int fNo;
	private int sNo;
	private int sessionSNo;
	
	public Friends() {}

	public Friends(int fNo, int sNo, int sessionSNo) {
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

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getSessionSNo() {
		return sessionSNo;
	}

	public void setSessionSNo(int sessionSNo) {
		this.sessionSNo = sessionSNo;
	}

	@Override
	public String toString() {
		return "Friends [fNo=" + fNo + ", sNo=" + sNo + ", sessionSNo=" + sessionSNo + "]";
	}

	
}
