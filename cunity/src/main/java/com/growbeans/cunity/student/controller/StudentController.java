package com.growbeans.cunity.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.departmentNotice.domain.DepartmentNotice;
import com.growbeans.cunity.departmentNotice.service.DepartmentNoticeService;
import com.growbeans.cunity.lecture.domain.Lecture;
import com.growbeans.cunity.lectureEnrollment.domain.LectureEnrollment;
import com.growbeans.cunity.lectureEnrollment.domain.Timetable;
import com.growbeans.cunity.lectureEnrollment.service.LectureEnrollmentService;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.service.StudentService;

@SessionAttributes({"loginStudent","judge"})
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private LectureEnrollmentService lecEnService;
	@Autowired
    private DepartmentNoticeService dService;
	
	
	
	// 학생로그인
	@RequestMapping(value="/studentLogin",method=RequestMethod.POST)
	public ModelAndView studentLogin(Student student, ModelAndView mv) {
		Student loginStudent = studentService.loginStudent(student);
		ArrayList<DepartmentNotice> dnlist = dService.noticeList();
		if(loginStudent != null) {
			int studentnum = 1;
			int sNo = student.getsNo();
			Timetable table = lecEnService.showList(sNo);
			List<Lecture> lectureEnList = lecEnService.lectureEnList(sNo);
			List<LectureEnrollment> gradeList = lecEnService.gradeList(sNo);
			mv.addObject("lectureEnList",lectureEnList);
			mv.addObject("gradeList", gradeList);
			mv.addObject("timetable", table);
			mv.addObject("loginStudent", loginStudent);
			mv.addObject("judge" , studentnum);
			mv.addObject("dnlist", dnlist);
			mv.setViewName("home");
		}
		else {
			mv.addObject("msg", "로그인 실패!");
			mv.setViewName("common/loginPage");
		}
		return mv;
	}
	
	// 학생로그아웃
    @RequestMapping("/studentLogout")
	public String studentLogout(SessionStatus status) {
    	status.setComplete();
		return "redirect:/";
	}
    
    //학생정보 조회
    // Student 담아서 보냄
//    @RequestMapping("/studentInfo")
//    public ModelAndView studentInfo(ModelAndView mv , int sNo) {
//    	mv.addObject(studentService.studentInfo(sNo));
//    	mv.setViewName("");
//		return mv;
//    }
    
    @RequestMapping("/studentInfo")
    public String studentinfo() {
    	return "student/studentInfo";
    }
    
    // 학생정보 업데이트 
    @RequestMapping(value ="/updateStudentInfo",method=RequestMethod.POST)
    public String updateStudent(Student student, Model model,RedirectAttributes rd) {
    	int result = studentService.updateStudent(student);
    	if(result>0) {
    		model.addAttribute("loginStudent", student);
    		rd.addFlashAttribute("msg", "정보 수정 성공");
    		return "student/studentInfo";
    	}else {
    		model.addAttribute("msg", "정보 수정 실패");
    		return "redirect:home";
    	}
    }
    
//		
//	}
	
	

}

