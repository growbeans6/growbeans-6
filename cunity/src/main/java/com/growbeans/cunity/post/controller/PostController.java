package com.growbeans.cunity.post.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.growbeans.cunity.Alarm.controller.AlarmController;
import com.growbeans.cunity.Alarm.domain.Alarm;
import com.growbeans.cunity.Alarm.service.AlarmService;
import com.growbeans.cunity.post.domain.PageInfo;
import com.growbeans.cunity.post.domain.Pagination;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.service.PostService;
import com.growbeans.cunity.student.domain.Student;



@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private AlarmService alarmService;
	
	// postList 출력하는
	@RequestMapping("postList")
	public ModelAndView postList(ModelAndView mv, String postKinds, @RequestParam(value="page", required=false) Integer page) throws UnsupportedEncodingException {
		
			if(postKinds.equals("자유")) {
				
				ArrayList<Post> list = postService.selectList(postKinds);
				
				mv.addObject("list", list);
				mv.setViewName("community/freePostList");
			} else if(postKinds.equals("장터")) {
				
				int currentPage = (page != null) ? page : 1;
				int listCount = postService.getListCount();
				PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
				
				ArrayList<Post> list = postService.selectList(postKinds, pi);
				
				mv.addObject("list", list);
				mv.addObject("pi", pi);
				mv.setViewName("community/marketPostList");
			}
		return mv;
	}
	
	/*@RequestMapping("marketPostList")
	public ModelAndView postList(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {

		int currentPage = (page != null) ? page : 1;
		int listCount = postService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		String postKinds="장터";
		
		ArrayList<Post> list = postService.selectList(postKinds, pi);
		
		if(!list.isEmpty()) {
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("community/marketPostList");
		} else {
			System.out.println("실패");
		}
		return mv;
	}*/
	
	//게시글 작성 화면
	@RequestMapping("postWrite")
	   public String postWrite() {
		   return "community/postWrite";
	   }
	
	//게시글 등록
	   @RequestMapping(value="insertPost", method = RequestMethod.POST)
	   public ModelAndView insertPost (Post post, ModelAndView mv, @RequestParam(name="uploadFile",required=false)MultipartFile uploadFile, HttpServletRequest request) {
		   // requestparam에 required 속성은 해당 파라미터가 반드시 필수인지 여부, 기본값은 true
		   // required=true, NULL 입력시 400 에러 발생
		   
		   // Multipart 지원 기능 -> 스프링 설정 파일에 MultipartResolver 등록
		   // MultipartResolver는 Multipart 형식으로 된 데이터가 전송된 경우 해당 데이터를 springMVC에서 사용할 수 있도록 변환
		   
		   //파일을 서버에 저장하는 작업
		   
		   if(!uploadFile.getOriginalFilename().equals("")) {
			   String filePath = saveFile(uploadFile, request);
			   
			   if(filePath != null) {
				   //실제 파일이름을 가져와서 filePath를 set한다.
				   post.setFilePath(uploadFile.getOriginalFilename());
			   }
		   }
		   //데이터를 DB에 저장하는 작업
		   int result = 0;
		   result = postService.insertPost(post, uploadFile, request);
		   int resultAlarm = 0;
		   
		   SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		   Date date = new Date();
		   
		   String sysdate = format.format(date);
		   
		   Alarm alarm = new Alarm();
		   alarm.setaContent(post.getPostSubject()+"게시글이 등록되었습니다.");
		   alarm.setsNo(post.getPostWriterSNo());
		   alarm.setaTime(sysdate);
		   
		   resultAlarm = alarmService.insertAlarmPost(alarm);
		   
		   String postKinds = null;
			
			try {
				postKinds = URLEncoder.encode(post.getPostKinds(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
		   if(result > 0) {
			   mv.setViewName("redirect:postList?postKinds=" + postKinds);
		   } else {
			   System.out.println("실패");
		   }
		   return mv;
	   }
	   
	   //파일 저장 메소드
	   public String saveFile(MultipartFile file, HttpServletRequest request) {
		   // 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
	    String savePath = root + "\\nuploadFiles";

	    // 저장 폴더 선택
	    File folder = new File(savePath);

	    // 만약 폴더가 없을 경우 자동 생성
	    if(!folder.exists()) {
	       folder.mkdir();
	    }
		   
		   String filePath = folder + "\\" + file.getOriginalFilename();
		   
			try {
				file.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		   return filePath;
	   }
	
	
	//게시글 상세조회
	@RequestMapping("postDetail")
	public ModelAndView postDetail(ModelAndView mv, int postNo) {

		Post post = postService.selectPost(postNo); // 게시글 상세 조회
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
		ArrayList<PostComment> postCommentList = postService.selectPostCommentList(postNo);
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
	@RequestMapping("addPostComment")
	@ResponseBody // ViewResolver를 거치지 않고(.jsp같은 suffix 안 붙이고) body에 String 값으로 바로 전송하는 어노테이션
	public String addpostComment(PostComment postComment, HttpSession session){
		/*Student loginUser = (Student)session.getAttribute("loginUser");
		String mentWriter = loginUser.getsName();
		postComment.setMentWriter(mentWriter);*/
		System.out.println(postComment.toString());
		int result = postService.insertPostComment(postComment);
		
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping("updatePost")
	public String updatePostView(int postNo, Model model) {
		model.addAttribute("post", postService.selectPost(postNo));
		return "community/postUpdate";
	}
	
	@RequestMapping("updatePostSubmit")
	public String noticeUpdate(Post post, Model model, HttpServletRequest request, MultipartFile reloadFile) {
		// 새로 업로드된 파일이 있을 경우
		if (reloadFile != null && !reloadFile.isEmpty()) {
			
			// 기존 업로드된 파일이 있을 경우
			if (post.getFilePath() != null) {
				// 기존 파일 삭제
				deleteFile(post.getFilePath(),request);
			}

			// 새로 업로드된 파일 저장
			String savePath = saveFile(reloadFile, request);

			// 새로 업로드된 파일이 잘 저장이 되었다면 디비 저장
			if (savePath != null) {
				post.setFilePath(reloadFile.getOriginalFilename());
			}
		}
		int result = postService.updatePost(post);
		return "redirect:postDetail?postNo=" + post.getPostNo();
	}
	
		// 파일 삭제 메소드
		// 게시글 등록 실패 또는 글 수정으로 업로드 파일이 변한 경우
		// 저장되어 있는 기존 파일 삭제
		public void deleteFile(String fileName, HttpServletRequest request) {
			// 파일 저장 경로 설정
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\nuploadFiles";
			// 삭제할 파일 경로 + 파일명
			File deleteFile = new File(savePath + "\\" + fileName);
			// 해당 파일이 존재할 경우 삭제
			if (deleteFile.exists()) {
				deleteFile.delete();
			}
		}

	
	@RequestMapping("deletePost")
	public String deletePostView(int postNo, String postKinds) {
		int result = postService.deletePost(postNo);
	return "redirect:/";
	}
}
