package com.growbeans.cunity.postImage.domain;

import java.sql.Date;

public class PostImage {

	private int imgNo;
	private String imgName;
	private String imgRoot;
	private Date imgUploadTime;
	private int postNo;
	
	public PostImage() {}

	public PostImage(int imgNo, String imgName, String imgRoot, Date imgUploadTime, int postNo) {
		super();
		this.imgNo = imgNo;
		this.imgName = imgName;
		this.imgRoot = imgRoot;
		this.imgUploadTime = imgUploadTime;
		this.postNo = postNo;
	}

	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgRoot() {
		return imgRoot;
	}

	public void setImgRoot(String imgRoot) {
		this.imgRoot = imgRoot;
	}

	public Date getImgUploadTime() {
		return imgUploadTime;
	}

	public void setImgUploadTime(Date imgUploadTime) {
		this.imgUploadTime = imgUploadTime;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "postImage [imgNo=" + imgNo + ", imgName=" + imgName + ", imgRoot=" + imgRoot + ", imgUploadTime="
				+ imgUploadTime + ", postNo=" + postNo + "]";
	}
	
	
}
