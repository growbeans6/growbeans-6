package com.growbeans.cunity.post.domain;

import java.sql.Date;

public class Post {

	private int postNo;
	private String postKinds;
	private String postCategory;
	private int postWriterSNo;
	private String postSubject;
	private String postContent;
	private Date postRegDate;
	private int studyNo;
	private String postWriterSName;
	private String filePath;
	
	public Post() {}

	public Post(int postNo, String postKinds, String postCategory, int postWriterSNo, String postSubject,
			String postContent, Date postRegDate, int studyNo, String postWriterSName, String filePath) {
		super();
		this.postNo = postNo;
		this.postKinds = postKinds;
		this.postCategory = postCategory;
		this.postWriterSNo = postWriterSNo;
		this.postSubject = postSubject;
		this.postContent = postContent;
		this.postRegDate = postRegDate;
		this.studyNo = studyNo;
		this.postWriterSName = postWriterSName;
		this.filePath = filePath;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostKinds() {
		return postKinds;
	}

	public void setPostKinds(String postKinds) {
		this.postKinds = postKinds;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public int getPostWriterSNo() {
		return postWriterSNo;
	}

	public void setPostWriterSNo(int postWriterSNo) {
		this.postWriterSNo = postWriterSNo;
	}

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostRegDate() {
		return postRegDate;
	}

	public void setPostRegDate(Date postRegDate) {
		this.postRegDate = postRegDate;
	}

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public String getPostWriterSName() {
		return postWriterSName;
	}

	public void setPostWriterSName(String postWriterSName) {
		this.postWriterSName = postWriterSName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Post [postNo=" + postNo + ", postKinds=" + postKinds + ", postCategory=" + postCategory
				+ ", postWriterSNo=" + postWriterSNo + ", postSubject=" + postSubject + ", postContent=" + postContent
				+ ", postRegDate=" + postRegDate + ", studyNo=" + studyNo + ", postWriterSName=" + postWriterSName
				+ ", filePath=" + filePath + "]";
	}
	
	

	
}
