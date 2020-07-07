package com.growbeans.cunity.post.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Post> selectList(String postKinds) {
		return postStore.selectList(postKinds);
	}

	@Override
	public int insertPost(Post post, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
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
		return 0;
	}

	@Override
	public int deletePost(int postNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<PostComment> selectPostCommentList(int postNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertPostComment(PostComment postComment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Post> searchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}
}
