package com.growbeans.cunity.friends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.growbeans.cunity.friends.service.FriendsService;

@Controller
public class FriendsController {

	@Autowired
	public FriendsService friendsService;
	
	@RequestMapping("friends")
	public String selectFriends() {
		return "community/newfriends";
	}
}
