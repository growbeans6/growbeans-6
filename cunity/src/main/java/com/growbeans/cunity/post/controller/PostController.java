package com.growbeans.cunity.post.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.service.PostService;
import com.growbeans.cunity.student.domain.Student;


@Controller
public class PostController {
	
	@Autowired
	private PostService pService;
	
	@RequestMapping("postList")
	public ModelAndView postList(ModelAndView mv, String postKinds) {

		ArrayList<Post> list = pService.selectList(postKinds);
		
		if(!list.isEmpty()) {
			mv.addObject("list", list);
			mv.setViewName("community/postList");
		} else {
			mv.addObject("msg", "게시글 전체 조회 실패");
			mv.setViewName("home");
		}
		return mv;
	}
	
	@RequestMapping("postDetail")
	public ModelAndView postDetail(ModelAndView mv, int postNo) {

		Post post = pService.selectPost(postNo); // 게시글 상세 조회
		if(post != null) {
			mv.addObject("post", post);
			mv.setViewName("community/post");
		} else {			
			mv.addObject("msg", "게시글 상세조회 실패");
			mv.setViewName("home");
		}
		return mv;
	}
	
	@RequestMapping("postCommentList")
	public void getPostCommentList(HttpServletResponse response, int postNo) throws JsonIOException, IOException{
		ArrayList<PostComment> postCommentList = pService.selectPostCommentList(postNo);
		//reply 객체를 JSON 형태로 변환해줘서 data로 보내줘야 함
		
		
		for(PostComment postComment : postCommentList) {
			postComment.setMentContent(URLEncoder.encode(postComment.getMentContent(), "utf-8"));
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(postCommentList, response.getWriter());
		//기존에 JSONObject, JSONArray를 이용해서 JSON형태로 만들어줬음
		//여기선 Gson 라이브러리를 사용하고자 함.
		//reply 객체를 JSON형태로 변환해줘서 DATA를 보내줘야 함.
	}
	
	//ajax
	@RequestMapping("addpostComment")
	@ResponseBody // ViewResolver를 거치지 않고(.jsp같은 suffix 안 붙이고) body에 String 값으로 바로 전송하는 어노테이션
	public String addpostComment(PostComment postComment, HttpSession session){
		Student loginUser = (Student)session.getAttribute("loginUser");
		String mentWriter = loginUser.getsName();
		postComment.setMentWriter(mentWriter);
		int result = pService.insertPostComment(postComment);
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
}
