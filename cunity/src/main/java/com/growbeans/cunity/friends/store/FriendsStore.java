package com.growbeans.cunity.friends.store;

import java.util.ArrayList;

import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.student.domain.Student;

public interface FriendsStore {
	public int insertFriends(Friends friends);
	public int receiveFriends(String fMessage);
	public ArrayList<Student> selectFriendsList(int sNo);
	public int deleteFriends(int lNo);
	public ArrayList<Student> findFriends(String sName);
}
