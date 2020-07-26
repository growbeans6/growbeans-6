package com.growbeans.cunity.post.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.growbeans.cunity.post.domain.PageInfo;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.Search;

public interface PostService {

	/**
	 *	1_1. 게시판 전체 수 조회 
	 * 
	 * @param pi
	 * @return list
	 */
	public int getListCount();
	
	/**
	 * 1. 자유, 강의평가 게시판 조회
	 * @param postKinds
	 * @return
	 */
	public ArrayList<Post> selectList(String postKinds);
	
	/**
	 * 1.1 장터 게시판 조회
	 * @param postKinds
	 * @param pi
	 * @return
	 */
	public ArrayList<Post> selectList(String postKinds, PageInfo pi);

	/**
	 * 2. 게시판 등록
	 * 
	 * @param post
	 * @return result
	 */
	public int insertPost(Post post, MultipartFile file, HttpServletRequest request);

	/**
	 * 3_1. 게시판 상세 조회시 조회수 증가
	 * 
	 * @param postNo
	 * @return result
	 */
	public int addReadCount(int postNo);

	/**
	 * 3_2. 게시판 상세 조회
	 * 
	 * @param postNo
	 * @return post
	 */
	public Post selectPost(int postNo);

	/**
	 * 4. 게시판 수정 
	 * 
	 * @param post
	 * @return result
	 */
	public int updatePost(Post post);

	/**
	 * 5. 게시판 삭제
	 * 
	 * @param postId
	 * @return result
	 */
	public int deletePost(int postNo);

	/**
	 * 6. 게시글 댓글 조회
	 * 
	 * @param postId
	 * @return list
	 */
	public ArrayList<PostComment> selectPostCommentList(int postNo);
	
	/**
	 * 7. 게시글 댓글 등록
	 * 
	 * @param postComment
	 * @return result
	 **/
	public int insertPostComment(PostComment postComment);
	
	/**
	 * 8. 게시글 검색
	 * @param search
	 * @return searchList
	 */
	public ArrayList<Post> searchList(Search search);
	
	public int updateMent(PostComment comment);
	public int deleteMent(int mentNo);
}
