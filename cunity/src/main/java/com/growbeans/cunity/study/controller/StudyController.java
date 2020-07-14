package com.growbeans.cunity.study.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.PostImage;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.study.service.StudyService;

@Controller
public class StudyController {

	@Autowired
	private StudyService studyService;

	// 스터디 메인페이지
	public ModelAndView studyMain() {
		return null;
	}

	// 스터디 타임라인 리스트
	@RequestMapping("/boardList")
	public String studyBoardList(Model mo, HttpSession session, RedirectAttributes ra) {
		Student student = (Student) session.getAttribute("loginStudent");
		if(student.getStudyNo()==0) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		ArrayList<Student> sList = studyService.selectStudyStudentList(student.getStudyNo());
		ArrayList<Post> pList = studyService.selectTimeLineList(student.getStudyNo(), "타임라인");
		// 스터디 학생 리스트
		mo.addAttribute("sList", sList);
		mo.addAttribute("pList", pList);
		// 글목록
	
		return "study/boardList";
	}

	// 스터디 타임라인 작성폼
	@RequestMapping("/boardWriteForm")
	public String studyBoardWriteForm(Model mo, HttpSession session, RedirectAttributes ra) {
		Student student = (Student) session.getAttribute("loginStudent");
		if(student.getStudyNo()==0) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		return "study/boardWrite";
	}

	// 스터디 타임라인 상세페이지
	@RequestMapping("/boardDetail")
	public String studyBoardDetail(Model mo, int postNo, HttpSession session, RedirectAttributes ra) {
		
		Post post = studyService.selectTimeLineDetail(postNo);
		Student student = (Student) session.getAttribute("loginStudent");
		if(student.getStudyNo()!=post.getStudyNo()) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		ArrayList<PostImage> postImages = studyService.selectTimeLineImage(postNo);
		ArrayList<PostComment> comments = studyService.selectPostCommentList(postNo);
		mo.addAttribute("timeLine", post);
		mo.addAttribute("imgList", postImages);
		mo.addAttribute("mentList", comments);


		return "study/boardDetail";
	}

	// 스터디 타임라인 수정폼
	@RequestMapping("/boardModifyForm")
	public String studyBoardModifyForm(Model mo, int postNo, HttpSession session, RedirectAttributes ra) {
		Post post = studyService.selectTimeLineDetail(postNo);
		Student student = (Student) session.getAttribute("loginStudent");
		if(student.getStudyNo()!=post.getStudyNo()) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		ArrayList<PostImage> postImages = studyService.selectTimeLineImage(postNo);
		mo.addAttribute("timeLine", post);
		mo.addAttribute("imgList", postImages);
		if (postImages != null) {
			mo.addAttribute("imgListSize", postImages.size());
		} else {
			mo.addAttribute("imgListSize", 0);
		}
		return "study/boardModify";
	}

	// 스터디 타임라인 수정
	@RequestMapping("/ModifyTimeLine")
	public String studyBoardModify(Model mo, Post post,
			@RequestParam(name = "fileImage", required = false) MultipartFile[] file, HttpServletRequest request,
			String upload_name1, String upload_name2, String upload_name3, HttpSession session, RedirectAttributes ra) {
		ArrayList<PostImage> postImages = studyService.selectTimeLineImage(post.getPostNo());
		int size = postImages.size();
		if (postImages != null) {
			for (int i = 0; i < size; i++) {
				if (!postImages.get(i).getImgName().equals(upload_name1)
						&& !postImages.get(i).getImgName().equals(upload_name2)
						&& !postImages.get(i).getImgName().equals(upload_name3)) {
					// 파일삭제
					deleteFile(postImages.get(i).getImgName(), request);
					studyService.deleteTimeLineImg(postImages.get(i).getImgNo());
				}
			}
		}
		// 파일이 있는지 검사
		if (file != null) {
			for (int i = 0; i < file.length; i++) {
				if (!file[i].getOriginalFilename().equals("")) {
					PostImage pImage = saveFile(i, file[i], request);
					studyService.insertTimeLineImg(pImage);
				}
			}
		}
		studyService.updateTimeLine(post);
		return "redirect:/boardList";
	}

	// 스터디 타임라인 작성
	@RequestMapping("/writeTimeline")
	public String studyBoardWrite(Model mo, Post post,
			@RequestParam(name = "fileImage", required = false) MultipartFile[] file, HttpServletRequest request
			, HttpSession session, RedirectAttributes ra) {

		studyService.insertTimeLine(post);

		// 파일이 있는지 검사
		if (file != null) {
			for (int i = 0; i < file.length; i++) {
				if (!file[i].getOriginalFilename().equals("")) {
					PostImage pImage = saveFile(i, file[i], request);
					studyService.insertTimeLineImg(pImage);
				}
			}
		}

	
		return "redirect:/boardList";
	}

	@RequestMapping("/deleteTimeLine")
	public String studyBoardDelete(Model mo, int postNo, HttpServletRequest request, HttpSession session, RedirectAttributes ra) {
		ArrayList<PostImage> postImages = studyService.selectTimeLineImage(postNo);
		if (postImages != null) {
			for (int i = 0; i < postImages.size(); i++) {
				deleteFile(postImages.get(i).getImgName(), request);
			}
		}
		studyService.deleteTimeLineImgAll(postNo);
		studyService.deleteTimeLine(postNo);

		return "redirect:/boardList";
	}

	// 댓글 작성
	@RequestMapping("/mentWrite")
	public String studyBoardMentInsert(Model mo, PostComment postComment, HttpSession session, RedirectAttributes ra) {
		studyService.insertMent(postComment);
		return "redirect:/boardDetail?postNo=" + postComment.getPostNo();
	}

	// 댓글 수정
	@RequestMapping("/mentUpdate")
	@ResponseBody
	public String studyBoardMentUpdate(Model mo, String mentContent, int mentNo, HttpSession session, RedirectAttributes ra) {
		int result = studyService.updateMent(mentContent,mentNo);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}

	// 댓글 삭제
	@RequestMapping("/mentDelete")
	@ResponseBody
	public String studyBoardMentDelete(Model mo,@RequestParam("mentNo") int mentNo, HttpSession session, RedirectAttributes ra) {
		int result = studyService.deleteMent(mentNo);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}

	// 스터디 생성
	public String studyCreate() {
		return null;
	}

	// 스터디 해체
	public String studyDisband() {
		return null;
	}

	// 스터디 이름 변경
	public String studyRename() {
		return null;
	}

	// 스터디 관리자 변경
	public String studyMgrModify() {
		return null;
	}

	// 스터디 가입수락
	public String studyJoin() {
		return null;
	}

	// 스터디 탈퇴
	public String studyWithdraw() {
		return null;
	}

	// 스터디 가입자 명단 불러오기 ajax
	public void studyMemberList() {

	}

	// 파일 저장 메소드
	public PostImage saveFile(int i, MultipartFile file, HttpServletRequest request) {

		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\studyFiles";

		// 저장 폴더 선택
		File folder = new File(savePath);

		// 만약 폴더가 없을 경우 자동 생성
		if (!folder.exists()) {
			folder.mkdir();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_");

		Date time = new Date();
		String index = i + "_";
		String upTime = format.format(time);
		// 파일명 중복을 방지하기위해 '파일을 넣는 순서_파일을 업로드한 시간_파일이름' 으로 파일을 저장
		String fileName = index + upTime + file.getOriginalFilename();
		String filePath = folder + "\\" + fileName;

		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostImage pImage = new PostImage();
		pImage.setImgRoot(filePath);
		pImage.setImgName(fileName);

		return pImage;
	}

	public void deleteFile(String fileName, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\\\studyFiles";
		// 삭제할 파일 경로 + 파일명
		File deleteFile = new File(savePath + "\\" + fileName);
		// 해당 파일이 존재할 경우 삭제
		if (deleteFile.exists()) {
			deleteFile.delete();
		}
	}
}
