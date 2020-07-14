package com.growbeans.cunity.post.domain;

import java.sql.Date;

public class PostComment {

	private int mentNo;
	private int postNo;
	private String mentWriter;
	private String mentContent;
	private Date mentRegDate;
	private int mentDepth;
	private String mentFilePath;
	public PostComment() {}

	public PostComment(int mentNo, int postNo, String mentWriter, String mentContent, Date mentRegDate, int mentDepth,
			String mentFilePath) {
		super();
		this.mentNo = mentNo;
		this.postNo = postNo;
		this.mentWriter = mentWriter;
		this.mentContent = mentContent;
		this.mentRegDate = mentRegDate;
		this.mentDepth = mentDepth;
		this.mentFilePath = mentFilePath;
	}



	public int getMentNo() {
		return mentNo;
	}

	public void setMentNo(int mentNo) {
		this.mentNo = mentNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getMentWriter() {
		return mentWriter;
	}

	public void setMentWriter(String mentWriter) {
		this.mentWriter = mentWriter;
	}

	public String getMentContent() {
		return mentContent;
	}

	public void setMentContent(String mentContent) {
		this.mentContent = mentContent;
	}

	public Date getMentRegDate() {
		return mentRegDate;
	}

	public void setMentRegDate(Date mentRegDate) {
		this.mentRegDate = mentRegDate;
	}

	public int getMentDepth() {
		return mentDepth;
	}

	public void setMentDepth(int mentDepth) {
		this.mentDepth = mentDepth;
	}

	public String getMentFilePath() {
		return mentFilePath;
	}

	public void setMentFilePath(String mentFilePath) {
		this.mentFilePath = mentFilePath;
	}

	@Override
	public String toString() {
		return "PostComment [mentNo=" + mentNo + ", postNo=" + postNo + ", mentWriter=" + mentWriter + ", mentContent="
				+ mentContent + ", mentRegDate=" + mentRegDate + ", mentDepth=" + mentDepth + ", mentFilePath="
				+ mentFilePath + "]";
	}

}
