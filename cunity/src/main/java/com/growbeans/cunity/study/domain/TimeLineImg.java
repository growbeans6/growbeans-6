package com.growbeans.cunity.study.domain;

public class TimeLineImg {
	private String upload_name1;
	private String upload_name2;
	private String upload_name3;
	public TimeLineImg() {
		// TODO Auto-generated constructor stub
	}
	public TimeLineImg(String upload_name1, String upload_name2, String upload_name3) {
		super();
		this.upload_name1 = upload_name1;
		this.upload_name2 = upload_name2;
		this.upload_name3 = upload_name3;
	}
	public String getUpload_name1() {
		return upload_name1;
	}
	public void setUpload_name1(String upload_name1) {
		this.upload_name1 = upload_name1;
	}
	public String getUpload_name2() {
		return upload_name2;
	}
	public void setUpload_name2(String upload_name2) {
		this.upload_name2 = upload_name2;
	}
	public String getUpload_name3() {
		return upload_name3;
	}
	public void setUpload_name3(String upload_name3) {
		this.upload_name3 = upload_name3;
	}
	@Override
	public String toString() {
		return "TimeLineImg [upload_name1=" + upload_name1 + ", upload_name2=" + upload_name2 + ", upload_name3="
				+ upload_name3 + "]";
	}
	
	
}
