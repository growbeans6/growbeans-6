package com.growbeans.cunity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.professor.domain.Professor;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		Student student = (Student)session.getAttribute("loginStudent");
		Professor professor = (Professor)session.getAttribute("loginprof");
		if(student==null && professor == null) {
			return "common/loginPage";
		} else if(student!=null && professor == null){
			return "redirect:/home";
		}else {
			return "redirect:professorhome";
		}
		
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value="/professorhome", method=RequestMethod.GET)
	public String professorhome(Model model) {
		return "professorhome";
	}
	
}
