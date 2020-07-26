package com.growbeans.cunity.post.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.post.domain.PageInfo;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.Search;

public interface PostStore {

	public int getListCount();
	public ArrayList<Post> selectList(String postKinds);
	public ArrayList<Post> selectList(String postKinds, PageInfo pi);
	public int insertPost(Post post, MultipartFile file, HttpServletRequest request);
	public int addReadCount(int postNo);
	public Post selectPost(int postNo);
	public int updatePost(Post post);
	public int deletePost(int postNo);
	public ArrayList<PostComment> selectPostCommentList(int postNo);
	public int insertPostComment(PostComment postComment);
	public ArrayList<Post> searchList(Search search);
	
	public int updateMent(PostComment comment);
	public int deleteMent(int mentNo);
}
