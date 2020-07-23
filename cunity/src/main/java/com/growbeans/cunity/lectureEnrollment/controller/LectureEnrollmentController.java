package com.growbeans.cunity.lectureEnrollment.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.professor.domain.Professor;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class LectureEnrollmentController {
	
	private Timetable table;
	
	public LectureEnrollmentController() {
		table = new Timetable();
		
		
	}
	
	@Autowired
	private LectureEnrollmentService lecEnService;
	

			@RequestMapping("/profGrade")
			public ModelAndView selectGrade(ModelAndView mv){
				mv.setViewName("professor/Grade");
				return mv;
			}
			
			//학생 성적 조회
			@RequestMapping("/stuGrade")
			public ModelAndView showGrade(ModelAndView mv, HttpSession session) {
				Student student = (Student)session.getAttribute("loginStudent");
				int sNo = student.getsNo();
				List<Lecture> lectureEnList = lecEnService.lectureEnList(sNo);
				List<LectureEnrollment> gradeList = lecEnService.gradeList(sNo);
				mv.addObject("lectureEnList",lectureEnList);
				mv.addObject("gradeList", gradeList);
				mv.addObject("sName", student.getsName());
				mv.setViewName("student/stuGrade");
				return mv;
			}

	//수강신청 리스트에 추가
	//세션에서 학번이랑, 강의정보에서 강의 코드 받아와서 데이터에 삽입
	@RequestMapping("/insertEnList")
	public String insertEnList(LectureEnrollment lecEn,HttpServletRequest request,HttpSession session, Model model) {
		int lcode = Integer.parseInt(request.getParameter("lcode"));
		Student student = (Student)session.getAttribute("loginStudent");
		lecEn.setsNo(student.getsNo());
		lecEn.setlCode(lcode);
		int sNo = student.getsNo();
		
		LectureEnrollment lecture1 = new LectureEnrollment();
		lecture1.setlCode(lcode);
		lecture1.setsNo(sNo);
		
		
		//중복된 과목있을경우 alert창 띄움
		if (lecEnService.find(lecture1) != null) {
			model.addAttribute("msg", "중복 신청 불가");
			model.addAttribute("url", "/lectureList");
			return "common/msg";
		}
		
		//같은 과목있을경우 alert창 띄움
		Lecture compareLec = new Lecture();
		compareLec =lecEnService.lectureOne(lcode);
		Lecture a = new Lecture();
		a.setsNo(student.getsNo());
		a.setlDay1(compareLec.getlDay1());
		a.setlDay2(compareLec.getlDay2());
		a.setlStartTime1(compareLec.getlStartTime1());
		a.setlStartTime2(compareLec.getlStartTime2());
		a.setlEndTime1(compareLec.getlEndTime1());
		a.setlEndTime2(compareLec.getlEndTime2());
		Lecture b = new Lecture(); 
				b = lecEnService.alreadyLecture(a);
		
		if( b != null) {
			model.addAttribute("msg", " 다른과목이 있습니다.");
			model.addAttribute("url", "/lectureList");
			return "common/msg";
		}
		
		
		// 스케쥴에 넣을과목 (새로운 학생으로 로그인했을경우 기존에 있던 시간표 불러옴)
		if(table.getsNo() != student.getsNo() ) {
			table = new Timetable();
			Timetable table1 = lecEnService.showList(sNo);
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
		
		table.setsNo(student.getsNo());
		
		
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
		int resultup = lecEnService.updateSchedule(table);
		int result = lecEnService.insertEnList(lecEn);
		
		if(result > 0 && resultup>0)
		{
			return "redirect:/lectureList";
		}else {
			return "home";
		}
		
	}
	
	//조인해서 가져올꺼임
	@RequestMapping("/lectureEnrollList")
	public ModelAndView lectureEnList(ModelAndView mv,HttpSession session) {
		Student student = (Student)session.getAttribute("loginStudent");
		int sNo = student.getsNo();
		List<Lecture> lectureEnList = lecEnService.lectureEnList(sNo);
		mv.addObject("lectureEnList",lectureEnList);
		mv.addObject("sName", student.getsName());
		mv.setViewName("lecture/lectureEnrollList");
		return mv;
	}
	
	@RequestMapping("/deleteEnList")
	public String deleteEnList(HttpServletRequest request, HttpSession session) {
		int lcode = Integer.parseInt(request.getParameter("lcode"));
		Student student = (Student)session.getAttribute("loginStudent");
		
		table.setsNo(student.getsNo());
		Lecture lecture = lecEnService.lectureOne(lcode);
		
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
		int resultup = lecEnService.updateSchedule(table);		
		int result = lecEnService.deleteEnList(lcode);
		if (result>0 && resultup >0) {
			return "redirect:/lectureEnrollList";
		}
		else {
			return "redirect:/lectureList";
		}
		
	}
	
	
	@RequestMapping("/schedule")
	public ModelAndView showSchedule(ModelAndView mv , HttpSession session) {
		Student student = (Student)session.getAttribute("loginStudent");
		int sNo = student.getsNo();
		Timetable table = lecEnService.showList(sNo);
		mv.addObject("timetable", table);
		mv.addObject("sName", student.getsName());
		mv.setViewName("lecture/lectureSchedule");
		return mv;
	}	
	
	@RequestMapping("/insertGrade")
	public String insertGrade(String sRate,HttpServletRequest request,int sNo,int lCode) {
		LectureEnrollment lectureenroll = new LectureEnrollment();
		lectureenroll.setlCode(lCode);
		lectureenroll.setsRate(sRate);
		lectureenroll.setsNo(sNo);
		int result = lecEnService.insertGrade(lectureenroll);
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	//강의 시간표
	@RequestMapping("/lectureTime")
	public ModelAndView showProSchedule(ModelAndView mv , HttpSession session) {
		Professor professor = (Professor)session.getAttribute("loginprof");
		int pNo = professor.getpNo();
		Timetable table = lecEnService.showProList(pNo);
		mv.addObject("timetable", table);
		mv.setViewName("professor/lectureTime");
		return mv;
	}	
	
	
	

}
