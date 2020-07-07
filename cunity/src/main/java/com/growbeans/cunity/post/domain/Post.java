package com.growbeans.cunity.post.domain;

public class Post {
// xdfdf
	private int postNo;
	private String postKinds;
	private String postCategory;
	private String postWriter;
	private String postSubject;
	private String postContent;
	private String postRegDate;
	private int studyNo;
	private String postWriterSName;
	
	public Post() {}

	public Post(int postNo, String postKinds, String postCategory, String postWriter, String postSubject,
			String postContent, String postRegDate, int studyNo, String postWriterSName) {
		super();
		this.postNo = postNo;
		this.postKinds = postKinds;
		this.postCategory = postCategory;
		this.postWriter = postWriter;
		this.postSubject = postSubject;
		this.postContent = postContent;
		this.postRegDate = postRegDate;
		this.studyNo = studyNo;
		this.postWriterSName = postWriterSName;
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

	public String getPostWriter() {
		return postWriter;
	}

	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
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

	public String getPostRegDate() {
		return postRegDate;
	}

	public void setPostRegDate(String postRegDate) {
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

	@Override
	public String toString() {
		return "Post [postNo=" + postNo + ", postKinds=" + postKinds + ", postCategory=" + postCategory
				+ ", postWriter=" + postWriter + ", postSubject=" + postSubject + ", postContent=" + postContent
				+ ", postRegDate=" + postRegDate + ", studyNo=" + studyNo + ", postWriterSName=" + postWriterSName
				+ "]";
	}

	
	
}
