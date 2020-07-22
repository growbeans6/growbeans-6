package com.growbeans.cunity.friends.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.friends.service.FriendsService;
import com.growbeans.cunity.student.domain.Student;

@Controller
public class FriendsController {

	@Autowired
	public FriendsService friendsService;
	
	@RequestMapping("friends")
	public ModelAndView selectFriendsList(ModelAndView mv, int sNo) {
		
		ArrayList<Student> friendsList = friendsService.selectFriendsList(sNo); 
		
			mv.addObject("friendsList", friendsList);
			mv.setViewName("community/newfriends");
		return mv;
	}
	
	//친구 신청을 위해 친구를 찾는
	@RequestMapping("findFriends")
	@ResponseBody // 데이터로서 값을 보내주기 위해, spring에서 ajax 쓸 때는 꼭 써야함
	public void findFriends(HttpServletResponse response, String sName) throws JsonIOException, IOException {
		
		ArrayList<Student> friendsList = friendsService.findFriends(sName);
	
		Gson gson = new Gson();
		gson.toJson(friendsList, response.getWriter());
	}
	
	@RequestMapping("insertFriends")
	public String addFriends(int sNo, int sessionSNo) {
		
		Friends friends = new Friends();
		friends.setsNo(sNo);
		friends.setSessionSNo(sessionSNo);
		
		int result = 0;
		result = friendsService.insertFriends(friends);
		
		return "redirect: friends";
	}
	
	@RequestMapping("requestFriends")
	public String requestFriends(int sessionSNo) {
		
		ArrayList<Friends> friends = friendsService.selectFriendsRequest(sessionSNo);
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
