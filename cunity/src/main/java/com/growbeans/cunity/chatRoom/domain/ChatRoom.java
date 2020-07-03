package com.growbeans.cunity.chatRoom.domain;

public class ChatRoom {
	private int studentNo;
	private int studyNo;
	private String studentName;
	private String studentImage;
	
	public ChatRoom() {
		// TODO Auto-generated constructor stub
	}

	public ChatRoom(int studentNo, int studyNo, String studentName, String studentImage) {
		super();
		this.studentNo = studentNo;
		this.studyNo = studyNo;
		this.studentName = studentName;
		this.studentImage = studentImage;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentImage() {
		return studentImage;
	}

	public void setStudentImage(String studentImage) {
		this.studentImage = studentImage;
	}

	@Override
	public String toString() {
		return "ChatRoom [studentNo=" + studentNo + ", studyNo=" + studyNo + ", studentName=" + studentName
				+ ", studentImage=" + studentImage + "]";
	}
	
	
}
