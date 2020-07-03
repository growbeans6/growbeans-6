package com.growbeans.cunity.friends.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.friends.store.FriendsStore;

@Service("friendsService")
public class FriendsServiceImpl implements FriendsService{

	@Autowired
	public FriendsStore friendsStore;

	@Override
	public int sendFriends(String fMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int receiveFriends(String fMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Friends> selectFriendsList(String sNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteFriends(int lNo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
