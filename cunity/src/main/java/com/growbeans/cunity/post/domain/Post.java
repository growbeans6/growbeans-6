package com.growbeans.cunity.post.domain;

public class Post {
// xdfdf
	private int postNo;
	private String postKinds;
	private String postCategory;
	private String postWriter;
	private String postSubject;
	private String postContent;
	private String postView;
	private String postRegDate;
	private int studyNo;
	
	public Post() {}

	public Post(int postNo, String postKinds, String postCategory, String postWriter, String postSubject,
			String postContent, String postView, String postRegDate, int studyNo) {
		super();
		this.postNo = postNo;
		this.postKinds = postKinds;
		this.postCategory = postCategory;
		this.postWriter = postWriter;
		this.postSubject = postSubject;
		this.postContent = postContent;
		this.postView = postView;
		this.postRegDate = postRegDate;
		this.studyNo = studyNo;
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

	public String getPostView() {
		return postView;
	}

	public void setPostView(String postView) {
		this.postView = postView;
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

	@Override
	public String toString() {
		return "post [postNo=" + postNo + ", postKinds=" + postKinds + ", postCategory=" + postCategory
				+ ", postWriter=" + postWriter + ", postSubject=" + postSubject + ", postContent=" + postContent
				+ ", postView=" + postView + ", postRegDate=" + postRegDate + ", studyNo=" + studyNo + "]";
	}
	
	
}
