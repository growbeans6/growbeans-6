package com.growbeans.cunity.friends.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.growbeans.cunity.friends.domain.Friends;
import com.growbeans.cunity.student.domain.Student;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Repository("friendsStore")
public class FriendsStoreLogic implements FriendsStore{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertFriends(Friends friends) {
		return sqlSession.insert("friendsMapper.insertFriends", friends);
	}

	@Override
	public int receiveFriends(String fMessage) {
		return 0;
	}

	@Override
	public ArrayList<Student> selectFriendsList(int sNo) {
		return (ArrayList)sqlSession.selectList("friendsMapper.selectFriendsList", sNo);
	}

	@Override
	public int deleteFriends(int lNo) {
		return 0;
	}

	@Override
	public ArrayList<Student> findFriends(String sName) {
		return (ArrayList)sqlSession.selectList("friendsMapper.findFriends", sName);
	}
}
