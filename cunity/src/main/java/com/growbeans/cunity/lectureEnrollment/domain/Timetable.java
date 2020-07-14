package com.growbeans.cunity.lectureEnrollment.domain;

public class Timetable {
	
	private int sNo;
	private int pNo;
	private int lCode;
	private String mon1;
	private String mon2;
	private String mon3;
	private String mon4;
	private String mon5;
	private String mon6;
	private String mon7;
	private String tue1;
	private String tue2;
	private String tue3;
	private String tue4;
	private String tue5;
	private String tue6;
	private String tue7;
	private String wed1;
	private String wed2;
	private String wed3;
	private String wed4;
	private String wed5;
	private String wed6;
	private String wed7;
	private String tur1;
	private String tur2;
	private String tur3;
	private String tur4;
	private String tur5;
	private String tur6;
	private String tur7;
	private String fri1;
	private String fri2;
	private String fri3;
	private String fri4;
	private String fri5;
	private String fri6;
	private String fri7;
	
	public Timetable() {
		super();
	}
	public Timetable(int sNo, int pNo, int lCode, String mon1, String mon2, String mon3, String mon4, String mon5,
			String mon6, String mon7, String tue1, String tue2, String tue3, String tue4, String tue5, String tue6,
			String tue7, String wed1, String wed2, String wed3, String wed4, String wed5, String wed6, String wed7,
			String tur1, String tur2, String tur3, String tur4, String tur5, String tur6, String tur7, String fri1,
			String fri2, String fri3, String fri4, String fri5, String fri6, String fri7) {
		super();
		this.sNo = sNo;
		this.pNo = pNo;
		this.lCode = lCode;
		this.mon1 = mon1;
		this.mon2 = mon2;
		this.mon3 = mon3;
		this.mon4 = mon4;
		this.mon5 = mon5;
		this.mon6 = mon6;
		this.mon7 = mon7;
		this.tue1 = tue1;
		this.tue2 = tue2;
		this.tue3 = tue3;
		this.tue4 = tue4;
		this.tue5 = tue5;
		this.tue6 = tue6;
		this.tue7 = tue7;
		this.wed1 = wed1;
		this.wed2 = wed2;
		this.wed3 = wed3;
		this.wed4 = wed4;
		this.wed5 = wed5;
		this.wed6 = wed6;
		this.wed7 = wed7;
		this.tur1 = tur1;
		this.tur2 = tur2;
		this.tur3 = tur3;
		this.tur4 = tur4;
		this.tur5 = tur5;
		this.tur6 = tur6;
		this.tur7 = tur7;
		this.fri1 = fri1;
		this.fri2 = fri2;
		this.fri3 = fri3;
		this.fri4 = fri4;
		this.fri5 = fri5;
		this.fri6 = fri6;
		this.fri7 = fri7;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getlCode() {
		return lCode;
	}
	public void setlCode(int lCode) {
		this.lCode = lCode;
	}
	public String getMon1() {
		return mon1;
	}
	public void setMon1(String mon1) {
		this.mon1 = mon1;
	}
	public String getMon2() {
		return mon2;
	}
	public void setMon2(String mon2) {
		this.mon2 = mon2;
	}
	public String getMon3() {
		return mon3;
	}
	public void setMon3(String mon3) {
		this.mon3 = mon3;
	}
	public String getMon4() {
		return mon4;
	}
	public void setMon4(String mon4) {
		this.mon4 = mon4;
	}
	public String getMon5() {
		return mon5;
	}
	public void setMon5(String mon5) {
		this.mon5 = mon5;
	}
	public String getMon6() {
		return mon6;
	}
	public void setMon6(String mon6) {
		this.mon6 = mon6;
	}
	public String getMon7() {
		return mon7;
	}
	public void setMon7(String mon7) {
		this.mon7 = mon7;
	}
	public String getTue1() {
		return tue1;
	}
	public void setTue1(String tue1) {
		this.tue1 = tue1;
	}
	public String getTue2() {
		return tue2;
	}
	public void setTue2(String tue2) {
		this.tue2 = tue2;
	}
	public String getTue3() {
		return tue3;
	}
	public void setTue3(String tue3) {
		this.tue3 = tue3;
	}
	public String getTue4() {
		return tue4;
	}
	public void setTue4(String tue4) {
		this.tue4 = tue4;
	}
	public String getTue5() {
		return tue5;
	}
	public void setTue5(String tue5) {
		this.tue5 = tue5;
	}
	public String getTue6() {
		return tue6;
	}
	public void setTue6(String tue6) {
		this.tue6 = tue6;
	}
	public String getTue7() {
		return tue7;
	}
	public void setTue7(String tue7) {
		this.tue7 = tue7;
	}
	public String getWed1() {
		return wed1;
	}
	public void setWed1(String wed1) {
		this.wed1 = wed1;
	}
	public String getWed2() {
		return wed2;
	}
	public void setWed2(String wed2) {
		this.wed2 = wed2;
	}
	public String getWed3() {
		return wed3;
	}
	public void setWed3(String wed3) {
		this.wed3 = wed3;
	}
	public String getWed4() {
		return wed4;
	}
	public void setWed4(String wed4) {
		this.wed4 = wed4;
	}
	public String getWed5() {
		return wed5;
	}
	public void setWed5(String wed5) {
		this.wed5 = wed5;
	}
	public String getWed6() {
		return wed6;
	}
	public void setWed6(String wed6) {
		this.wed6 = wed6;
	}
	public String getWed7() {
		return wed7;
	}
	public void setWed7(String wed7) {
		this.wed7 = wed7;
	}
	public String getTur1() {
		return tur1;
	}
	public void setTur1(String tur1) {
		this.tur1 = tur1;
	}
	public String getTur2() {
		return tur2;
	}
	public void setTur2(String tur2) {
		this.tur2 = tur2;
	}
	public String getTur3() {
		return tur3;
	}
	public void setTur3(String tur3) {
		this.tur3 = tur3;
	}
	public String getTur4() {
		return tur4;
	}
	public void setTur4(String tur4) {
		this.tur4 = tur4;
	}
	public String getTur5() {
		return tur5;
	}
	public void setTur5(String tur5) {
		this.tur5 = tur5;
	}
	public String getTur6() {
		return tur6;
	}
	public void setTur6(String tur6) {
		this.tur6 = tur6;
	}
	public String getTur7() {
		return tur7;
	}
	public void setTur7(String tur7) {
		this.tur7 = tur7;
	}
	public String getFri1() {
		return fri1;
	}
	public void setFri1(String fri1) {
		this.fri1 = fri1;
	}
	public String getFri2() {
		return fri2;
	}
	public void setFri2(String fri2) {
		this.fri2 = fri2;
	}
	public String getFri3() {
		return fri3;
	}
	public void setFri3(String fri3) {
		this.fri3 = fri3;
	}
	public String getFri4() {
		return fri4;
	}
	public void setFri4(String fri4) {
		this.fri4 = fri4;
	}
	public String getFri5() {
		return fri5;
	}
	public void setFri5(String fri5) {
		this.fri5 = fri5;
	}
	public String getFri6() {
		return fri6;
	}
	public void setFri6(String fri6) {
		this.fri6 = fri6;
	}
	public String getFri7() {
		return fri7;
	}
	public void setFri7(String fri7) {
		this.fri7 = fri7;
	}
	
	
	
	
	
	
	

}
