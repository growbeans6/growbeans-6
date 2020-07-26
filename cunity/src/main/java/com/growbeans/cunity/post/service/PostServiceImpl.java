package com.growbeans.cunity.post.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.post.domain.PageInfo;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.Search;
import com.growbeans.cunity.post.store.PostStore;

@Service("postService")
public class PostServiceImpl implements PostService{

	@Autowired
	public PostStore postStore;

	@Override
	public int getListCount() {
		return postStore.getListCount();
	}

	@Override
	public ArrayList<Post> selectList(String postKinds) {
		return postStore.selectList(postKinds);
	}
	
	@Override
	public ArrayList<Post> selectList(String postKinds, PageInfo pi) {
		return postStore.selectList(postKinds, pi);
	}

	@Override
	public int insertPost(Post post, MultipartFile file, HttpServletRequest request) {
		return postStore.insertPost(post, file, request);
	}

	@Override
	public int addReadCount(int postNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Post selectPost(int postNo) {
		return postStore.selectPost(postNo);
	}

	@Override
	public int updatePost(Post post) {
		// TODO Auto-generated method stub
		return postStore.updatePost(post);
	}

	@Override
	public int deletePost(int postNo) {
		return postStore.deletePost(postNo);
	}

	@Override
	public ArrayList<PostComment> selectPostCommentList(int postNo) {
		// TODO Auto-generated method stub
		return postStore.selectPostCommentList(postNo);
	}

	@Override
	public int insertPostComment(PostComment postComment) {
		return postStore.insertPostComment(postComment);
	}

	@Override
	public ArrayList<Post> searchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMent(PostComment comment) {
		// TODO Auto-generated method stub
		return postStore.updateMent(comment);
	}

	@Override
	public int deleteMent(int mentNo) {
		// TODO Auto-generated method stub
		return postStore.deleteMent(mentNo);
	}

}
