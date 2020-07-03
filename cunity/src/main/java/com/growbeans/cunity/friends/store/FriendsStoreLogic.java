package com.growbeans.cunity.friends.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("friendsStore")
public class FriendsStoreLogic implements FriendsStore{

	@Autowired
	private SqlSession sqlSession;
}
