package com.growbeans.cunity.professor.domain;

public class Professor {

	
	private int pNo;
	private String pPwd;
	private String pDept;
	private String pName;
	private String pPhone;
	private String pAddress;
	private String pEmail;
	private String pFile;
	
	
	public Professor() {}
	
	
	public Professor(int pNo, String pPwd, String pDept, String pName, String pPhone, String pAddress, String pEmail, String pFile) {
		super();
		this.pNo = pNo;
		this.pPwd = pPwd;
		this.pDept = pDept;
		this.pName = pName;
		this.pPhone = pPhone;
		this.pAddress = pAddress;
		this.pEmail = pEmail;
		this.pFile = pFile;
	}


	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	
	
	public String getpPwd() {
		return pPwd;
	}


	public void setpPwd(String pPwd) {
		this.pPwd = pPwd;
	}


	public String getpDept() {
		return pDept;
	}


	public void setpDept(String pDept) {
		this.pDept = pDept;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpPhone() {
		return pPhone;
	}


	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}


	public String getpAddress() {
		return pAddress;
	}


	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}


	public String getpEmail() {
		return pEmail;
	}


	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}


	public String getpFile() {
		return pFile;
	}


	public void setpFile(String pFile) {
		this.pFile = pFile;
	}


	@Override
	public String toString() {
		return "Professor [pNo=" + pNo + ", pPwd=" + pPwd + ", pDept=" + pDept + ", pName=" + pName + ", pPhone=" + pPhone + ", pAddress="
				+ pAddress + ", pEmail=" + pEmail + ", pFile=" + pFile + "]";
	}
	
	
}
