package com.growbeans.cunity.studyFile.domain;

import java.util.Date;

public class StudyFile {

	private int fileNo; // 파일 번호
	private int studyNo; // 스터디 번호
	private String uploadFile; // 파일명
	private String filePath; // 파일경로
	private Date fileUploadTime; // 업로드시간
	private int folderNo; // 폴더번호
	private String fileRegistrant; // 파일 작성자

	public StudyFile() {
	}
	
	public StudyFile(int fileNo, int studyNo, String uploadFile, String filePath, Date fileUploadTime, int folderNo,
			String fileRegistrant) {
		super();
		this.fileNo = fileNo;
		this.studyNo = studyNo;
		this.uploadFile = uploadFile;
		this.filePath = filePath;
		this.fileUploadTime = fileUploadTime;
		this.folderNo = folderNo;
		this.fileRegistrant = fileRegistrant;
	}



	public String getFileRegistrant() {
		return fileRegistrant;
	}

	public void setFileRegistrant(String fileRegistrant) {
		this.fileRegistrant = fileRegistrant;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getFileUploadTime() {
		return fileUploadTime;
	}

	public void setFileUploadTime(Date fileUploadTime) {
		this.fileUploadTime = fileUploadTime;
	}

	public int getFolderNo() {
		return folderNo;
	}

	public void setFolderNo(int folderNo) {
		this.folderNo = folderNo;
	}

	@Override
	public String toString() {
		return "StudyFile [fileNo=" + fileNo + ", studyNo=" + studyNo + ", uploadFile=" + uploadFile + ", filePath="
				+ filePath + ", fileUploadTime=" + fileUploadTime + ", folderNo=" + folderNo + ", fileRegistrant="
				+ fileRegistrant + "]";
	}


}
