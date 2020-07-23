package com.growbeans.cunity.lecture.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lecture.service.LectureService;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class LectureController {
	
	private Timetable table;
	
	public  LectureController() {
		table = new Timetable();
	}
	
	@Autowired
	private LectureService lecService;
	
	@Autowired
	private LectureEnrollmentService lecEnService;
	
	//전체리스트 띄워서 수강신청 리스트에서 사용
	@RequestMapping("/lectureList")
	public ModelAndView allLecture(ModelAndView mv) {
		List<Lecture> lectureList = lecService.allLectureList();
		mv.addObject("lectureList",lectureList);
		mv.setViewName("lecture/lectureList");
		return mv;
	}
	
	//강의추가하는페이지로 이동
	@RequestMapping("/lectureInsertPage")
	public ModelAndView insertLecturePage(ModelAndView mv,HttpSession session) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		mv.addObject("professor", professor);
		mv.setViewName("professor/lectureInsert");
		return mv;
	}

	
	//강의 등록
	@RequestMapping(value="/lectureInsert", method=RequestMethod.POST)
	public String insertLecture(HttpSession session, Lecture lecture1,Model model) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		lecture1.setpNo(professor.getpNo());
		
		
		//해야함
		if(lecture1.getLcode() == 1) {
			model.addAttribute("msg", "존재하는 과목코드입니다.");
			model.addAttribute("url", "/lectureInsertPage");
			return "common/msg";
		}

		Lecture compareLec = new Lecture();
		compareLec.setpNo(professor.getpNo());
		compareLec.setlDay1(lecture1.getlDay1());
		compareLec.setlStartTime1(lecture1.getlStartTime1());
		compareLec.setlEndTime1(lecture1.getlEndTime1());
		compareLec.setlDay2(lecture1.getlDay2());
		compareLec.setlStartTime2(lecture1.getlStartTime2());
		compareLec.setlEndTime2(lecture1.getlEndTime2());
		
		List<Lecture> b = lecEnService.alreadyProLecture(compareLec);
		
		if( !b.isEmpty() ) {
			model.addAttribute("msg", " 다른과목이 있습니다.");
			model.addAttribute("url", "/lectureInsertPage");
			return "common/msg";
		}
		
		int insertok = lecService.insertLecture(lecture1);
		
		if(table.getpNo() != professor.getpNo() ) {
			table = new Timetable();
			Timetable table1 = lecEnService.showProList(professor.getpNo());
			table.setMon1(table1.getMon1());
			table.setMon2(table1.getMon2());
			table.setMon3(table1.getMon3());
			table.setMon4(table1.getMon4());
			table.setMon5(table1.getMon5());
			table.setMon6(table1.getMon6());
			table.setTue1(table1.getTue1());
			table.setTue2(table1.getTue2());
			table.setTue3(table1.getTue3());
			table.setTue4(table1.getTue4());
			table.setTue5(table1.getTue5());
			table.setTue6(table1.getTue6());
			table.setTue7(table1.getTue7());
			table.setWed1(table1.getWed1());
			table.setWed2(table1.getWed2());
			table.setWed3(table1.getWed3());
			table.setWed4(table1.getWed4());
			table.setWed5(table1.getWed5());
			table.setWed6(table1.getWed6());
			table.setWed7(table1.getWed7());
			table.setTur1(table1.getTur1());
			table.setTur2(table1.getTur2());
			table.setTur3(table1.getTur3());
			table.setTur4(table1.getTur4());
			table.setTur5(table1.getTur5());
			table.setTur6(table1.getTur6());
			table.setTur7(table1.getTur7());
			table.setFri1(table1.getFri1());
			table.setFri2(table1.getFri2());
			table.setFri3(table1.getFri3());
			table.setFri4(table1.getFri4());
			table.setFri5(table1.getFri5());
			table.setFri6(table1.getFri6());
			table.setFri7(table1.getFri7());
		}
		
		table.setpNo(professor.getpNo());
		
		if(insertok > 0) {
			int lcode = lecture1.getLcode();
			
			Lecture lecture = lecEnService.lectureOne(lcode);
			
			if(lecture.getlDay1().equals("월")) {
				if(lecture.getlStartTime1() == 1) {
					String mon1 = lecture.getlName();
					table.setMon1(mon1);	
				}
				if(lecture.getlStartTime1() == 2) {
					String mon2 = lecture.getlName();
					table.setMon2(mon2);	
				}
				if(lecture.getlStartTime1() == 3) {
					String mon3 = lecture.getlName();
					table.setMon3(mon3);	
				}
				
				if(lecture.getlStartTime1() == 4) {
					String mon4 = lecture.getlName();
					table.setMon4(mon4);	
				}
				
				if(lecture.getlStartTime1() == 5) {
					String mon5 = lecture.getlName();
					table.setMon5(mon5);	
				}
				
				if(lecture.getlStartTime1() == 6) {
					String mon6 = lecture.getlName();
					table.setMon6(mon6);	
				}	
			}
			if(lecture.getlDay1().equals("화")) {
				if(lecture.getlStartTime1() == 1) {
					String tue1 = lecture.getlName();
					table.setTue1(tue1);	
				}
				if(lecture.getlStartTime1() == 2) {
					String tue2 = lecture.getlName();
					table.setTue2(tue2);
				}
				if(lecture.getlStartTime1() == 3) {
					String tue3 = lecture.getlName();
					table.setTue3(tue3);	
				}
				
				if(lecture.getlStartTime1() == 4) {
					String tue4 = lecture.getlName();
					table.setTue4(tue4);	
				}
				
				if(lecture.getlStartTime1() == 5) {
					String tue5 = lecture.getlName();
					table.setTue5(tue5);	
				}
				
				if(lecture.getlStartTime1() == 6) {
					String tue6 = lecture.getlName();
					table.setTue6(tue6);	
				}	
			}
			if(lecture.getlDay1().equals("수")) {
				if(lecture.getlStartTime1() == 1) {
					String wed1 = lecture.getlName();
					table.setWed1(wed1);	
				}
				if(lecture.getlStartTime1() == 2) {
					String wed2 = lecture.getlName();
					table.setWed2(wed2);
				}
				if(lecture.getlStartTime1() == 3) {
					String wed3 = lecture.getlName();
					table.setWed3(wed3);	
				}
				
				if(lecture.getlStartTime1() == 4) {
					String wed4 = lecture.getlName();
					table.setWed4(wed4);	
				}
				
				if(lecture.getlStartTime1() == 5) {
					String wed5 = lecture.getlName();
					table.setWed5(wed5);	
				}
				
				if(lecture.getlStartTime1() == 6) {
					String wed6 = lecture.getlName();
					table.setWed6(wed6);	
				}	
			}
			
			if(lecture.getlDay1().equals("목")) {
				if(lecture.getlStartTime1() == 1) {
					String tur1 = lecture.getlName();
					table.setTur1(tur1);	
				}
				if(lecture.getlStartTime1() == 2) {
					String tur2 = lecture.getlName();
					table.setTur2(tur2);
				}
				if(lecture.getlStartTime1() == 3) {
					String tur3 = lecture.getlName();
					table.setTur3(tur3);	
				}
				
				if(lecture.getlStartTime1() == 4) {
					String tur4 = lecture.getlName();
					table.setTur4(tur4);	
				}
				
				if(lecture.getlStartTime1() == 5) {
					String tur5 = lecture.getlName();
					table.setTur5(tur5);	
				}
				
				if(lecture.getlStartTime1() == 6) {
					String tur6 = lecture.getlName();
					table.setTur6(tur6);	
				}	
			}
			
			if(lecture.getlDay1().equals("금")) {
				if(lecture.getlStartTime1() == 1) {
					String fri1 = lecture.getlName();
					table.setFri1(fri1);	
				}
				if(lecture.getlStartTime1() == 2) {
					String fri2 = lecture.getlName();
					table.setFri2(fri2);
				}
				if(lecture.getlStartTime1() == 3) {
					String fri3 = lecture.getlName();
					table.setFri3(fri3);	
				}
				
				if(lecture.getlStartTime1() == 4) {
					String fri4 = lecture.getlName();
					table.setFri4(fri4);	
				}
				
				if(lecture.getlStartTime1() == 5) {
					String fri5 = lecture.getlName();
					table.setFri5(fri5);	
				}
				
				if(lecture.getlStartTime1() == 6) {
					String fri6 = lecture.getlName();
					table.setFri6(fri6);	
				}	
			}
			
			//2번째
			
			if(lecture.getlDay1().equals("월")) {
				if(lecture.getlEndTime1() == 1) {
					String mon1 = lecture.getlName();
					table.setMon1(mon1);	
				}
				if(lecture.getlEndTime1() == 2) {
					String mon2 = lecture.getlName();
					table.setMon2(mon2);	
				}
				if(lecture.getlEndTime1() == 3) {
					String mon3 = lecture.getlName();
					table.setMon3(mon3);	
				}
				
				if(lecture.getlEndTime1() == 4) {
					String mon4 = lecture.getlName();
					table.setMon4(mon4);	
				}
				
				if(lecture.getlEndTime1() == 5) {
					String mon5 = lecture.getlName();
					table.setMon5(mon5);	
				}
				
				if(lecture.getlEndTime1() == 6) {
					String mon6 = lecture.getlName();
					table.setMon6(mon6);	
				}	
			}
			if(lecture.getlDay1().equals("화")) {
				if(lecture.getlEndTime1() == 1) {
					String tue1 = lecture.getlName();
					table.setTue1(tue1);	
				}
				if(lecture.getlEndTime1() == 2) {
					String tue2 = lecture.getlName();
					table.setTue2(tue2);
				}
				if(lecture.getlEndTime1() == 3) {
					String tue3 = lecture.getlName();
					table.setTue3(tue3);	
				}
				
				if(lecture.getlEndTime1() == 4) {
					String tue4 = lecture.getlName();
					table.setTue4(tue4);	
				}
				
				if(lecture.getlEndTime1() == 5) {
					String tue5 = lecture.getlName();
					table.setTue5(tue5);	
				}
				
				if(lecture.getlEndTime1() == 6) {
					String tue6 = lecture.getlName();
					table.setTue6(tue6);	
				}	
			}
			if(lecture.getlDay1().equals("수")) {
				if(lecture.getlEndTime1() == 1) {
					String wed1 = lecture.getlName();
					table.setWed1(wed1);	
				}
				if(lecture.getlEndTime1() == 2) {
					String wed2 = lecture.getlName();
					table.setWed2(wed2);
				}
				if(lecture.getlEndTime1() == 3) {
					String wed3 = lecture.getlName();
					table.setWed3(wed3);	
				}
				
				if(lecture.getlEndTime1() == 4) {
					String wed4 = lecture.getlName();
					table.setWed4(wed4);	
				}
				
				if(lecture.getlEndTime1() == 5) {
					String wed5 = lecture.getlName();
					table.setWed5(wed5);	
				}
				
				if(lecture.getlEndTime1() == 6) {
					String wed6 = lecture.getlName();
					table.setWed6(wed6);	
				}	
			}
			
			if(lecture.getlDay1().equals("목")) {
				if(lecture.getlEndTime1() == 1) {
					String tur1 = lecture.getlName();
					table.setTur1(tur1);	
				}
				if(lecture.getlEndTime1() == 2) {
					String tur2 = lecture.getlName();
					table.setTur2(tur2);
				}
				if(lecture.getlEndTime1() == 3) {
					String tur3 = lecture.getlName();
					table.setTur3(tur3);	
				}
				
				if(lecture.getlEndTime1() == 4) {
					String tur4 = lecture.getlName();
					table.setTur4(tur4);	
				}
				
				if(lecture.getlEndTime1() == 5) {
					String tur5 = lecture.getlName();
					table.setTur5(tur5);	
				}
				
				if(lecture.getlEndTime1() == 6) {
					String tur6 = lecture.getlName();
					table.setTur6(tur6);	
				}	
			}
			
			if(lecture.getlDay1().equals("금")) {
				if(lecture.getlEndTime1() == 1) {
					String fri1 = lecture.getlName();
					table.setFri1(fri1);	
				}
				if(lecture.getlEndTime1() == 2) {
					String fri2 = lecture.getlName();
					table.setFri2(fri2);
				}
				if(lecture.getlEndTime1() == 3) {
					String fri3 = lecture.getlName();
					table.setFri3(fri3);	
				}
				
				if(lecture.getlEndTime1() == 4) {
					String fri4 = lecture.getlName();
					table.setFri4(fri4);	
				}
				
				if(lecture.getlEndTime1() == 5) {
					String fri5 = lecture.getlName();
					table.setFri5(fri5);	
				}
				
				if(lecture.getlEndTime1() == 6) {
					String fri6 = lecture.getlName();
					table.setFri6(fri6);	
				}	
			}
			
			//2번째날 시간표
			
			if(lecture.getlDay2().equals("월")) {
				if(lecture.getlStartTime2() == 1) {
					String mon1 = lecture.getlName();
					table.setMon1(mon1);	
				}
				if(lecture.getlStartTime2() == 2) {
					String mon2 = lecture.getlName();
					table.setMon2(mon2);	
				}
				if(lecture.getlStartTime2() == 3) {
					String mon3 = lecture.getlName();
					table.setMon3(mon3);	
				}
				
				if(lecture.getlStartTime2() == 4) {
					String mon4 = lecture.getlName();
					table.setMon4(mon4);	
				}
				
				if(lecture.getlStartTime2() == 5) {
					String mon5 = lecture.getlName();
					table.setMon5(mon5);	
				}
				
				if(lecture.getlStartTime2() == 6) {
					String mon6 = lecture.getlName();
					table.setMon6(mon6);	
				}	
			}
			if(lecture.getlDay2().equals("화")) {
				if(lecture.getlStartTime2() == 1) {
					String tue1 = lecture.getlName();
					table.setTue1(tue1);	
				}
				if(lecture.getlStartTime2() == 2) {
					String tue2 = lecture.getlName();
					table.setTue2(tue2);
				}
				if(lecture.getlStartTime2() == 3) {
					String tue3 = lecture.getlName();
					table.setTue3(tue3);	
				}
				
				if(lecture.getlStartTime2() == 4) {
					String tue4 = lecture.getlName();
					table.setTue4(tue4);	
				}
				
				if(lecture.getlStartTime2() == 5) {
					String tue5 = lecture.getlName();
					table.setTue5(tue5);	
				}
				
				if(lecture.getlStartTime2() == 6) {
					String tue6 = lecture.getlName();
					table.setTue6(tue6);	
				}	
			}
			if(lecture.getlDay2().equals("수")) {
				if(lecture.getlStartTime2() == 1) {
					String wed1 = lecture.getlName();
					table.setWed1(wed1);	
				}
				if(lecture.getlStartTime2() == 2) {
					String wed2 = lecture.getlName();
					table.setWed2(wed2);
				}
				if(lecture.getlStartTime2() == 3) {
					String wed3 = lecture.getlName();
					table.setWed3(wed3);	
				}
				
				if(lecture.getlStartTime2() == 4) {
					String wed4 = lecture.getlName();
					table.setWed4(wed4);	
				}
				
				if(lecture.getlStartTime2() == 5) {
					String wed5 = lecture.getlName();
					table.setWed5(wed5);	
				}
				
				if(lecture.getlStartTime2() == 6) {
					String wed6 = lecture.getlName();
					table.setWed6(wed6);	
				}	
			}
			
			if(lecture.getlDay2().equals("목")) {
				if(lecture.getlStartTime2() == 1) {
					String tur1 = lecture.getlName();
					table.setTur1(tur1);	
				}
				if(lecture.getlStartTime2() == 2) {
					String tur2 = lecture.getlName();
					table.setTur2(tur2);
				}
				if(lecture.getlStartTime2() == 3) {
					String tur3 = lecture.getlName();
					table.setTur3(tur3);	
				}
				
				if(lecture.getlStartTime2() == 4) {
					String tur4 = lecture.getlName();
					table.setTur4(tur4);	
				}
				
				if(lecture.getlStartTime2() == 5) {
					String tur5 = lecture.getlName();
					table.setTur5(tur5);	
				}
				
				if(lecture.getlStartTime2() == 6) {
					String tur6 = lecture.getlName();
					table.setTur6(tur6);	
				}	
			}
			
			if(lecture.getlDay2().equals("금")) {
				if(lecture.getlStartTime2() == 1) {
					String fri1 = lecture.getlName();
					table.setFri1(fri1);	
				}
				if(lecture.getlStartTime2() == 2) {
					String fri2 = lecture.getlName();
					table.setFri2(fri2);
				}
				if(lecture.getlStartTime2() == 3) {
					String fri3 = lecture.getlName();
					table.setFri3(fri3);	
				}
				
				if(lecture.getlStartTime2() == 4) {
					String fri4 = lecture.getlName();
					table.setFri4(fri4);	
				}
				
				if(lecture.getlStartTime2() == 5) {
					String fri5 = lecture.getlName();
					table.setFri5(fri5);	
				}
				
				if(lecture.getlStartTime2() == 6) {
					String fri6 = lecture.getlName();
					table.setFri6(fri6);	
				}	
			}
			
			//2번째
			
			if(lecture.getlDay2().equals("월")) {
				if(lecture.getlEndTime2() == 1) {
					String mon1 = lecture.getlName();
					table.setMon1(mon1);	
				}
				if(lecture.getlEndTime2() == 2) {
					String mon2 = lecture.getlName();
					table.setMon2(mon2);	
				}
				if(lecture.getlEndTime2() == 3) {
					String mon3 = lecture.getlName();
					table.setMon3(mon3);	
				}
				
				if(lecture.getlEndTime2() == 4) {
					String mon4 = lecture.getlName();
					table.setMon4(mon4);	
				}
				
				if(lecture.getlEndTime2() == 5) {
					String mon5 = lecture.getlName();
					table.setMon5(mon5);	
				}
				
				if(lecture.getlEndTime2() == 6) {
					String mon6 = lecture.getlName();
					table.setMon6(mon6);	
				}	
			}
			if(lecture.getlDay2().equals("화")) {
				if(lecture.getlEndTime2() == 1) {
					String tue1 = lecture.getlName();
					table.setTue1(tue1);	
				}
				if(lecture.getlEndTime2() == 2) {
					String tue2 = lecture.getlName();
					table.setTue2(tue2);
				}
				if(lecture.getlEndTime2() == 3) {
					String tue3 = lecture.getlName();
					table.setTue3(tue3);	
				}
				
				if(lecture.getlEndTime2() == 4) {
					String tue4 = lecture.getlName();
					table.setTue4(tue4);	
				}
				
				if(lecture.getlEndTime2() == 5) {
					String tue5 = lecture.getlName();
					table.setTue5(tue5);	
				}
				
				if(lecture.getlEndTime2() == 6) {
					String tue6 = lecture.getlName();
					table.setTue6(tue6);	
				}	
			}
			if(lecture.getlDay2().equals("수")) {
				if(lecture.getlEndTime2() == 1) {
					String wed1 = lecture.getlName();
					table.setWed1(wed1);	
				}
				if(lecture.getlEndTime2() == 2) {
					String wed2 = lecture.getlName();
					table.setWed2(wed2);
				}
				if(lecture.getlEndTime2() == 3) {
					String wed3 = lecture.getlName();
					table.setWed3(wed3);	
				}
				
				if(lecture.getlEndTime2() == 4) {
					String wed4 = lecture.getlName();
					table.setWed4(wed4);	
				}
				
				if(lecture.getlEndTime2() == 5) {
					String wed5 = lecture.getlName();
					table.setWed5(wed5);	
				}
				
				if(lecture.getlEndTime2() == 6) {
					String wed6 = lecture.getlName();
					table.setWed6(wed6);	
				}	
			}
			
			if(lecture.getlDay2().equals("목")) {
				if(lecture.getlEndTime2() == 1) {
					String tur1 = lecture.getlName();
					table.setTur1(tur1);	
				}
				if(lecture.getlEndTime2() == 2) {
					String tur2 = lecture.getlName();
					table.setTur2(tur2);
				}
				if(lecture.getlEndTime2() == 3) {
					String tur3 = lecture.getlName();
					table.setTur3(tur3);	
				}
				
				if(lecture.getlEndTime2() == 4) {
					String tur4 = lecture.getlName();
					table.setTur4(tur4);	
				}
				
				if(lecture.getlEndTime2() == 5) {
					String tur5 = lecture.getlName();
					table.setTur5(tur5);	
				}
				
				if(lecture.getlEndTime2() == 6) {
					String tur6 = lecture.getlName();
					table.setTur6(tur6);	
				}	
			}
			
			if(lecture.getlDay2().equals("금")) {
				if(lecture.getlEndTime2() == 1) {
					String fri1 = lecture.getlName();
					table.setFri1(fri1);	
				}
				if(lecture.getlEndTime2() == 2) {
					String fri2 = lecture.getlName();
					table.setFri2(fri2);
				}
				if(lecture.getlEndTime2() == 3) {
					String fri3 = lecture.getlName();
					table.setFri3(fri3);	
				}
				
				if(lecture.getlEndTime2() == 4) {
					String fri4 = lecture.getlName();
					table.setFri4(fri4);	
				}
				
				if(lecture.getlEndTime2() == 5) {
					String fri5 = lecture.getlName();
					table.setFri5(fri5);	
				}
				
				if(lecture.getlEndTime2() == 6) {
					String fri6 = lecture.getlName();
					table.setFri6(fri6);	
				}	
			}
			int resultup = lecEnService.updateProSchedule(table);
		}//if문 끝

		return "redirect:/prolectureList";
	}
	
	//강의 삭제
	@RequestMapping("/deleteLecture")
	public String deleteLecture(int lCode, HttpSession session) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		Lecture lecture = lecEnService.lectureOne(lCode);
		
		if(lecture.getlDay1().equals("월")) {
			if(lecture.getlStartTime1() == 1) {
				String mon1 = lecture.getlName();
				table.setMon1(null);	
			}
			if(lecture.getlStartTime1() == 2) {
				String mon2 = lecture.getlName();
				table.setMon2(null);	
			}
			if(lecture.getlStartTime1() == 3) {
				String mon3 = lecture.getlName();
				table.setMon3(null);	
			}
			
			if(lecture.getlStartTime1() == 4) {
				String mon4 = lecture.getlName();
				table.setMon4(null);	
			}
			
			if(lecture.getlStartTime1() == 5) {
				String mon5 = lecture.getlName();
				table.setMon5(null);	
			}
			
			if(lecture.getlStartTime1() == 6) {
				String mon6 = lecture.getlName();
				table.setMon6(null);	
			}	
		}
		if(lecture.getlDay1().equals("화")) {
			if(lecture.getlStartTime1() == 1) {
				String tue1 = lecture.getlName();
				table.setTue1(null);	
			}
			if(lecture.getlStartTime1() == 2) {
				String tue2 = lecture.getlName();
				table.setTue2(null);
			}
			if(lecture.getlStartTime1() == 3) {
				String tue3 = lecture.getlName();
				table.setTue3(null);	
			}
			
			if(lecture.getlStartTime1() == 4) {
				String tue4 = lecture.getlName();
				table.setTue4(null);	
			}
			
			if(lecture.getlStartTime1() == 5) {
				String tue5 = lecture.getlName();
				table.setTue5(null);	
			}
			
			if(lecture.getlStartTime1() == 6) {
				String tue6 = lecture.getlName();
				table.setTue6(null);	
			}	
		}
		if(lecture.getlDay1().equals("수")) {
			if(lecture.getlStartTime1() == 1) {
				String wed1 = lecture.getlName();
				table.setWed1(null);	
			}
			if(lecture.getlStartTime1() == 2) {
				String wed2 = lecture.getlName();
				table.setWed2(null);
			}
			if(lecture.getlStartTime1() == 3) {
				String wed3 = lecture.getlName();
				table.setWed3(null);	
			}
			
			if(lecture.getlStartTime1() == 4) {
				String wed4 = lecture.getlName();
				table.setWed4(null);	
			}
			
			if(lecture.getlStartTime1() == 5) {
				String wed5 = lecture.getlName();
				table.setWed5(null);	
			}
			
			if(lecture.getlStartTime1() == 6) {
				String wed6 = lecture.getlName();
				table.setWed6(null);	
			}	
		}
		
		if(lecture.getlDay1().equals("목")) {
			if(lecture.getlStartTime1() == 1) {
				String tur1 = lecture.getlName();
				table.setTur1(null);	
			}
			if(lecture.getlStartTime1() == 2) {
				String tur2 = lecture.getlName();
				table.setTur2(null);
			}
			if(lecture.getlStartTime1() == 3) {
				String tur3 = lecture.getlName();
				table.setTur3(null);	
			}
			
			if(lecture.getlStartTime1() == 4) {
				String tur4 = lecture.getlName();
				table.setTur4(null);	
			}
			
			if(lecture.getlStartTime1() == 5) {
				String tur5 = lecture.getlName();
				table.setTur5(null);	
			}
			
			if(lecture.getlStartTime1() == 6) {
				String tur6 = lecture.getlName();
				table.setTur6(null);	
			}	
		}
		
		if(lecture.getlDay1().equals("금")) {
			if(lecture.getlStartTime1() == 1) {
				String fri1 = lecture.getlName();
				table.setFri1(null);	
			}
			if(lecture.getlStartTime1() == 2) {
				String fri2 = lecture.getlName();
				table.setFri2(null);
			}
			if(lecture.getlStartTime1() == 3) {
				String fri3 = lecture.getlName();
				table.setFri3(null);	
			}
			
			if(lecture.getlStartTime1() == 4) {
				String fri4 = lecture.getlName();
				table.setFri4(null);	
			}
			
			if(lecture.getlStartTime1() == 5) {
				String fri5 = lecture.getlName();
				table.setFri5(null);	
			}
			
			if(lecture.getlStartTime1() == 6) {
				String fri6 = lecture.getlName();
				table.setFri6(null);	
			}	
		}
		
		//2번째
		
		if(lecture.getlDay1().equals("월")) {
			if(lecture.getlEndTime1() == 1) {
				String mon1 = lecture.getlName();
				table.setMon1(null);	
			}
			if(lecture.getlEndTime1() == 2) {
				String mon2 = lecture.getlName();
				table.setMon2(null);	
			}
			if(lecture.getlEndTime1() == 3) {
				String mon3 = lecture.getlName();
				table.setMon3(null);	
			}
			
			if(lecture.getlEndTime1() == 4) {
				String mon4 = lecture.getlName();
				table.setMon4(null);	
			}
			
			if(lecture.getlEndTime1() == 5) {
				String mon5 = lecture.getlName();
				table.setMon5(null);	
			}
			
			if(lecture.getlEndTime1() == 6) {
				String mon6 = lecture.getlName();
				table.setMon6(null);	
			}	
		}
		if(lecture.getlDay1().equals("화")) {
			if(lecture.getlEndTime1() == 1) {
				String tue1 = lecture.getlName();
				table.setTue1(null);	
			}
			if(lecture.getlEndTime1() == 2) {
				String tue2 = lecture.getlName();
				table.setTue2(null);
			}
			if(lecture.getlEndTime1() == 3) {
				String tue3 = lecture.getlName();
				table.setTue3(null);	
			}
			
			if(lecture.getlEndTime1() == 4) {
				String tue4 = lecture.getlName();
				table.setTue4(null);	
			}
			
			if(lecture.getlEndTime1() == 5) {
				String tue5 = lecture.getlName();
				table.setTue5(null);	
			}
			
			if(lecture.getlEndTime1() == 6) {
				String tue6 = lecture.getlName();
				table.setTue6(null);	
			}	
		}
		if(lecture.getlDay1().equals("수")) {
			if(lecture.getlEndTime1() == 1) {
				String wed1 = lecture.getlName();
				table.setWed1(null);	
			}
			if(lecture.getlEndTime1() == 2) {
				String wed2 = lecture.getlName();
				table.setWed2(null);
			}
			if(lecture.getlEndTime1() == 3) {
				String wed3 = lecture.getlName();
				table.setWed3(null);	
			}
			
			if(lecture.getlEndTime1() == 4) {
				String wed4 = lecture.getlName();
				table.setWed4(null);	
			}
			
			if(lecture.getlEndTime1() == 5) {
				String wed5 = lecture.getlName();
				table.setWed5(null);	
			}
			
			if(lecture.getlEndTime1() == 6) {
				String wed6 = lecture.getlName();
				table.setWed6(null);	
			}	
		}
		
		if(lecture.getlDay1().equals("목")) {
			if(lecture.getlEndTime1() == 1) {
				String tur1 = lecture.getlName();
				table.setTur1(null);	
			}
			if(lecture.getlEndTime1() == 2) {
				String tur2 = lecture.getlName();
				table.setTur2(null);
			}
			if(lecture.getlEndTime1() == 3) {
				String tur3 = lecture.getlName();
				table.setTur3(null);	
			}
			
			if(lecture.getlEndTime1() == 4) {
				String tur4 = lecture.getlName();
				table.setTur4(null);	
			}
			
			if(lecture.getlEndTime1() == 5) {
				String tur5 = lecture.getlName();
				table.setTur5(null);	
			}
			
			if(lecture.getlEndTime1() == 6) {
				String tur6 = lecture.getlName();
				table.setTur6(null);	
			}	
		}
		
		if(lecture.getlDay1().equals("금")) {
			if(lecture.getlEndTime1() == 1) {
				String fri1 = lecture.getlName();
				table.setFri1(null);	
			}
			if(lecture.getlEndTime1() == 2) {
				String fri2 = lecture.getlName();
				table.setFri2(null);
			}
			if(lecture.getlEndTime1() == 3) {
				String fri3 = lecture.getlName();
				table.setFri3(null);	
			}
			
			if(lecture.getlEndTime1() == 4) {
				String fri4 = lecture.getlName();
				table.setFri4(null);	
			}
			
			if(lecture.getlEndTime1() == 5) {
				String fri5 = lecture.getlName();
				table.setFri5(null);	
			}
			
			if(lecture.getlEndTime1() == 6) {
				String fri6 = lecture.getlName();
				table.setFri6(null);	
			}	
		}
		
		//2번째날 시간표
		
		if(lecture.getlDay2().equals("월")) {
			if(lecture.getlStartTime2() == 1) {
				String mon1 = lecture.getlName();
				table.setMon1(null);	
			}
			if(lecture.getlStartTime2() == 2) {
				String mon2 = lecture.getlName();
				table.setMon2(null);	
			}
			if(lecture.getlStartTime2() == 3) {
				String mon3 = lecture.getlName();
				table.setMon3(null);	
			}
			
			if(lecture.getlStartTime2() == 4) {
				String mon4 = lecture.getlName();
				table.setMon4(null);	
			}
			
			if(lecture.getlStartTime2() == 5) {
				String mon5 = lecture.getlName();
				table.setMon5(null);	
			}
			
			if(lecture.getlStartTime2() == 6) {
				String mon6 = lecture.getlName();
				table.setMon6(null);	
			}	
		}
		if(lecture.getlDay2().equals("화")) {
			if(lecture.getlStartTime2() == 1) {
				String tue1 = lecture.getlName();
				table.setTue1(null);	
			}
			if(lecture.getlStartTime2() == 2) {
				String tue2 = lecture.getlName();
				table.setTue2(null);
			}
			if(lecture.getlStartTime2() == 3) {
				String tue3 = lecture.getlName();
				table.setTue3(null);	
			}
			
			if(lecture.getlStartTime2() == 4) {
				String tue4 = lecture.getlName();
				table.setTue4(null);	
			}
			
			if(lecture.getlStartTime2() == 5) {
				String tue5 = lecture.getlName();
				table.setTue5(null);	
			}
			
			if(lecture.getlStartTime2() == 6) {
				String tue6 = lecture.getlName();
				table.setTue6(null);	
			}	
		}
		if(lecture.getlDay2().equals("수")) {
			if(lecture.getlStartTime2() == 1) {
				String wed1 = lecture.getlName();
				table.setWed1(null);	
			}
			if(lecture.getlStartTime2() == 2) {
				String wed2 = lecture.getlName();
				table.setWed2(null);
			}
			if(lecture.getlStartTime2() == 3) {
				String wed3 = lecture.getlName();
				table.setWed3(null);	
			}
			
			if(lecture.getlStartTime2() == 4) {
				String wed4 = lecture.getlName();
				table.setWed4(null);	
			}
			
			if(lecture.getlStartTime2() == 5) {
				String wed5 = lecture.getlName();
				table.setWed5(null);	
			}
			
			if(lecture.getlStartTime2() == 6) {
				String wed6 = lecture.getlName();
				table.setWed6(null);	
			}	
		}
		
		if(lecture.getlDay2().equals("목")) {
			if(lecture.getlStartTime2() == 1) {
				String tur1 = lecture.getlName();
				table.setTur1(null);	
			}
			if(lecture.getlStartTime2() == 2) {
				String tur2 = lecture.getlName();
				table.setTur2(null);
			}
			if(lecture.getlStartTime2() == 3) {
				String tur3 = lecture.getlName();
				table.setTur3(null);	
			}
			
			if(lecture.getlStartTime2() == 4) {
				String tur4 = lecture.getlName();
				table.setTur4(null);	
			}
			
			if(lecture.getlStartTime2() == 5) {
				String tur5 = lecture.getlName();
				table.setTur5(null);	
			}
			
			if(lecture.getlStartTime2() == 6) {
				String tur6 = lecture.getlName();
				table.setTur6(null);	
			}	
		}
		
		if(lecture.getlDay2().equals("금")) {
			if(lecture.getlStartTime2() == 1) {
				String fri1 = lecture.getlName();
				table.setFri1(null);	
			}
			if(lecture.getlStartTime2() == 2) {
				String fri2 = lecture.getlName();
				table.setFri2(null);
			}
			if(lecture.getlStartTime2() == 3) {
				String fri3 = lecture.getlName();
				table.setFri3(null);	
			}
			
			if(lecture.getlStartTime2() == 4) {
				String fri4 = lecture.getlName();
				table.setFri4(null);	
			}
			
			if(lecture.getlStartTime2() == 5) {
				String fri5 = lecture.getlName();
				table.setFri5(null);	
			}
			
			if(lecture.getlStartTime2() == 6) {
				String fri6 = lecture.getlName();
				table.setFri6(null);	
			}	
		}
		
		//2번째
		
		if(lecture.getlDay2().equals("월")) {
			if(lecture.getlEndTime2() == 1) {
				String mon1 = lecture.getlName();
				table.setMon1(null);	
			}
			if(lecture.getlEndTime2() == 2) {
				String mon2 = lecture.getlName();
				table.setMon2(null);	
			}
			if(lecture.getlEndTime2() == 3) {
				String mon3 = lecture.getlName();
				table.setMon3(null);	
			}
			
			if(lecture.getlEndTime2() == 4) {
				String mon4 = lecture.getlName();
				table.setMon4(null);	
			}
			
			if(lecture.getlEndTime2() == 5) {
				String mon5 = lecture.getlName();
				table.setMon5(null);	
			}
			
			if(lecture.getlEndTime2() == 6) {
				String mon6 = lecture.getlName();
				table.setMon6(null);	
			}	
		}
		if(lecture.getlDay2().equals("화")) {
			if(lecture.getlEndTime2() == 1) {
				String tue1 = lecture.getlName();
				table.setTue1(null);	
			}
			if(lecture.getlEndTime2() == 2) {
				String tue2 = lecture.getlName();
				table.setTue2(null);
			}
			if(lecture.getlEndTime2() == 3) {
				String tue3 = lecture.getlName();
				table.setTue3(null);	
			}
			
			if(lecture.getlEndTime2() == 4) {
				String tue4 = lecture.getlName();
				table.setTue4(null);	
			}
			
			if(lecture.getlEndTime2() == 5) {
				String tue5 = lecture.getlName();
				table.setTue5(null);	
			}
			
			if(lecture.getlEndTime2() == 6) {
				String tue6 = lecture.getlName();
				table.setTue6(null);	
			}	
		}
		if(lecture.getlDay2().equals("수")) {
			if(lecture.getlEndTime2() == 1) {
				String wed1 = lecture.getlName();
				table.setWed1(null);	
			}
			if(lecture.getlEndTime2() == 2) {
				String wed2 = lecture.getlName();
				table.setWed2(null);
			}
			if(lecture.getlEndTime2() == 3) {
				String wed3 = lecture.getlName();
				table.setWed3(null);	
			}
			
			if(lecture.getlEndTime2() == 4) {
				String wed4 = lecture.getlName();
				table.setWed4(null);	
			}
			
			if(lecture.getlEndTime2() == 5) {
				String wed5 = lecture.getlName();
				table.setWed5(null);	
			}
			
			if(lecture.getlEndTime2() == 6) {
				String wed6 = lecture.getlName();
				table.setWed6(null);	
			}	
		}
		
		if(lecture.getlDay2().equals("목")) {
			if(lecture.getlEndTime2() == 1) {
				String tur1 = lecture.getlName();
				table.setTur1(null);	
			}
			if(lecture.getlEndTime2() == 2) {
				String tur2 = lecture.getlName();
				table.setTur2(null);
			}
			if(lecture.getlEndTime2() == 3) {
				String tur3 = lecture.getlName();
				table.setTur3(null);	
			}
			
			if(lecture.getlEndTime2() == 4) {
				String tur4 = lecture.getlName();
				table.setTur4(null);	
			}
			
			if(lecture.getlEndTime2() == 5) {
				String tur5 = lecture.getlName();
				table.setTur5(null);	
			}
			
			if(lecture.getlEndTime2() == 6) {
				String tur6 = lecture.getlName();
				table.setTur6(null);	
			}	
		}
		
		if(lecture.getlDay2().equals("금")) {
			if(lecture.getlEndTime2() == 1) {
				String fri1 = lecture.getlName();
				table.setFri1(null);	
			}
			if(lecture.getlEndTime2() == 2) {
				String fri2 = lecture.getlName();
				table.setFri2(null);
			}
			if(lecture.getlEndTime2() == 3) {
				String fri3 = lecture.getlName();
				table.setFri3(null);	
			}
			
			if(lecture.getlEndTime2() == 4) {
				String fri4 = lecture.getlName();
				table.setFri4(null);	
			}
			
			if(lecture.getlEndTime2() == 5) {
				String fri5 = lecture.getlName();
				table.setFri5(null);	
			}
			
			if(lecture.getlEndTime2() == 6) {
				String fri6 = lecture.getlName();
				table.setFri6(null);	
			}	
		}
		table.setpNo(professor.getpNo());
		int resultup = lecEnService.updateProSchedule(table);	
		lecService.deleteLecture(lCode);
		
		return "redirect:/prolectureList";
	}
	

	// 강의 내 수강생 목록 조회
	@RequestMapping("/lStudentList")
	public ModelAndView lecStudentList(ModelAndView mv, int lCode,String lName) {
		List<Student> lecStudentList = lecService.lecStudentList(lCode);
		mv.addObject("lCode",lCode);
		mv.addObject("lName", lName);
		mv.addObject("lecStudentList", lecStudentList);
		mv.setViewName("professor/studentList1");
		return mv;
	}
	
	// 강의 내 수강생 목록 조회
	@RequestMapping("/prolectureList")
	public ModelAndView prolectureList(ModelAndView mv, HttpSession session) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		int pNo = professor.getpNo();
		List<Lecture> proLectureList = lecService.proLectureList(pNo);
		mv.addObject("proLectureList", proLectureList);
		mv.addObject("pName", professor.getpName());
		mv.setViewName("professor/lectureList");
		return mv;
	}
	

}
