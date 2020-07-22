package com.growbeans.cunity.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.service.StudentService;

@SessionAttributes({"loginStudent","judge"})
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// 학생로그인
	@RequestMapping(value="/studentLogin",method=RequestMethod.POST)
	public ModelAndView studentLogin(Student student, ModelAndView mv) {
		Student loginStudent = studentService.loginStudent(student);
		if(loginStudent != null) {
			int studentnum = 1;
			mv.addObject("loginStudent", loginStudent);
			mv.addObject("judge" , studentnum);
			mv.setViewName("redirect:/home");
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

