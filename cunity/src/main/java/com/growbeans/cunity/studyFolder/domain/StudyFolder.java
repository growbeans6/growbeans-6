package com.growbeans.cunity.studyFolder.domain;

public class StudyFolder {

	private int folderNo; // 폴더번호
	private int studyNo; // 스터디번호
	private String folderName; // 폴더명
	private int parentFolderNo; // 부모폴더번호
	
	public StudyFolder() {}

	public StudyFolder(int folderNo, int studyNo, String folderName, int parentFolderNo) {
		super();
		this.folderNo = folderNo;
		this.studyNo = studyNo;
		this.folderName = folderName;
		this.parentFolderNo = parentFolderNo;
	}

	public int getFolderNo() {
		return folderNo;
	}

	public void setFolderNo(int folderNo) {
		this.folderNo = folderNo;
	}

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public int getParentFolderNo() {
		return parentFolderNo;
	}

	public void setParentFolderNo(int parentFolderNo) {
		this.parentFolderNo = parentFolderNo;
	}

	@Override
	public String toString() {
		return "StudyFolder [folderNo=" + folderNo + ", studyNo=" + studyNo + ", folderName=" + folderName
				+ ", parentFolderNo=" + parentFolderNo + "]";
	}
	
	
}
