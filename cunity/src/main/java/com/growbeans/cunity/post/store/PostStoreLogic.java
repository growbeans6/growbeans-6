package com.growbeans.cunity.post.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postStore")
public class PostStoreLogic implements PostStore{

	@Autowired
	private SqlSession sqlSession;
}
