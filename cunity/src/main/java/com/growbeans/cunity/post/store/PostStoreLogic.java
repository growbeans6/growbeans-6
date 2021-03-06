package com.growbeans.cunity.post.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.post.domain.PageInfo;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.Search;

@Repository("postStore")
public class PostStoreLogic implements PostStore{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Post> selectList(String postKinds) {
		return (ArrayList)sqlSession.selectList("postMapper.selectList", postKinds);
	}
	
	@Override
	public int getListCount() {
		return sqlSession.selectOne("postMapper.getListCount");
	}
	
	@Override
	public ArrayList<Post> selectList(String postKinds, PageInfo pi) {
		//mybatis의 rowBounds 클래스 사용
		//off: 얼마나 건너뛸 것인가, 증가값
		//limit: 고정값, 내가 가져오고 싶은 갯수
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("postMapper.selectList2", null, rowBounds);
	}

	@Override
	public int insertPost(Post post, MultipartFile file, HttpServletRequest request) {
		return sqlSession.insert("postMapper.insertPost", post);
	}

	@Override
	public int addReadCount(int postNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Post selectPost(int postNo) {
		return sqlSession.selectOne("postMapper.selectPost", postNo);
	}

	@Override
	public int updatePost(Post post) {
		return sqlSession.update("postMapper.updatePost", post);
	}

	@Override
	public int deletePost(int postNo) {
		return sqlSession.delete("postMapper.deletePost", postNo);
	}

	@Override
	public ArrayList<PostComment> selectPostCommentList(int postNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("postMapper.selectPostCommentList", postNo);
	}

	@Override
	public int insertPostComment(PostComment postComment) {
		return sqlSession.insert("postMapper.insertPostComment", postComment);
	}

	@Override
	public ArrayList<Post> searchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMent(PostComment comment) {
		// TODO Auto-generated method stub
		return sqlSession.update("postMapper.updateMent", comment);
	}

	@Override
	public int deleteMent(int mentNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("postMapper.deleteMent",mentNo);
	}


}
