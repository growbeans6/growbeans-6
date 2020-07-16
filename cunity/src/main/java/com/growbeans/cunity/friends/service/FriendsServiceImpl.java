package com.growbeans.cunity.friends.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.friends.store.FriendsStore;
import com.growbeans.cunity.student.domain.Student;

@Service("friendsService")
public class FriendsServiceImpl implements FriendsService{

	@Autowired
	public FriendsStore friendsStore;

	@Override
	public int insertFriends(Friends friends) {
		return friendsStore.insertFriends(friends);
	}

	@Override
	public int receiveFriends(String fMessage) {
		// TODO Auto-generated method stubbn 
		return 0;
	}

	@Override
	public ArrayList<Student> selectFriendsList(int sNo) {
		return friendsStore.selectFriendsList(sNo);
	}

	@Override
	public int deleteFriends(int lNo) {
		return 0;
	}

	@Override
	public ArrayList<Student> findFriends(String sName) {
		return friendsStore.findFriends(sName);
	}
}
