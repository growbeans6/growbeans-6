package com.growbeans.cunity.study.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.growbeans.cunity.chatRoom.domain.ChatRoom;
import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.PostImage;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.service.StudentService;
import com.growbeans.cunity.study.domain.Study;
import com.growbeans.cunity.study.domain.TimeLineImg;
import com.growbeans.cunity.study.service.StudyService;

@Controller
@RequestMapping("/study-timeline")
@SessionAttributes({"loginStudent"})
public class StudyController {

	@Autowired
	private StudyService studyService;
	@Autowired
	private StudentService studentService;

	// 스터디 타임라인 리스트
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String studyBoardList(Model mo, HttpSession session, RedirectAttributes ra) {
		Student student = (Student) session.getAttribute("loginStudent");
		if (student.getStudyNo() == 0) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		ArrayList<Student> sList = studyService.selectStudyStudentList(student.getStudyNo());
		ArrayList<Post> pList = studyService.selectTimeLineList(student.getStudyNo(), "타임라인");
		Study study = studyService.selectStudy(student.getStudyNo());
		if (pList.size() > 30) {
			for (int i = 0; i < pList.size(); i++) {
				if (i >= 30) {
					pList.remove(i);
				}
			}
		}
		mo.addAttribute("sList", sList);
		mo.addAttribute("pList", pList);
		mo.addAttribute("study", study);

		return "study/boardList";
	}

	// 스터디 타임라인 작성폼
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String studyBoardWriteForm(Model mo, HttpSession session, RedirectAttributes ra) {
		Student student = (Student) session.getAttribute("loginStudent");
		if (student.getStudyNo() == 0) {
			ra.addFlashAttribute("msg", "스터디에 가입한 사용자만 이용할 수 있는 기능입니다.");
			return "redirect:/home";
		}
		return "study/boardWrite";
	}

	// 스터디 타임라인 상세페이지
	@RequestMapping(value = "/board/{postNo}", method = RequestMethod.GET)
	public String studyBoardDetail(Model mo, @PathVariable("postNo") int postNo, HttpSession session,
			RedirectAttributes ra) {

		Post post = studyService.selectTimeLineDetail(postNo);
		Student student = (Student) session.getAttribute("loginStudent");
		if (student.getStudyNo() != post.getStudyNo()) {
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
	@RequestMapping(value = "/board/modify/{postNo}", method = RequestMethod.GET)
	public String studyBoardModifyForm(Model mo, @PathVariable("postNo") int postNo, HttpSession session,
			RedirectAttributes ra) {
		Post post = studyService.selectTimeLineDetail(postNo);
		Student student = (Student) session.getAttribute("loginStudent");
		if (student.getStudyNo() != post.getStudyNo()) {
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
	@RequestMapping(value = "/board/update")
	public String studyBoardModify(Model mo, Post post,
			@RequestParam(name = "fileImage", required = false) MultipartFile[] file, HttpServletRequest request,
			TimeLineImg img, HttpSession session, RedirectAttributes ra) {
		String upload_name1 = img.getUpload_name1();
		String upload_name2 = img.getUpload_name2();
		String upload_name3 = img.getUpload_name3();
		System.out.println(img.toString());
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
		return "redirect:/study-timeline/board/" + post.getPostNo();
	}

	// 스터디 타임라인 작성
	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public String studyBoardWrite(Model mo, Post post,
			@RequestParam(name = "fileImage", required = false) MultipartFile[] file, HttpServletRequest request,
			HttpSession session, RedirectAttributes ra) {

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

		return "redirect:/study-timeline/board";
	}

	// 게시글 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String studyBoardDelete(Model mo, int postNo, HttpServletRequest request, HttpSession session,
			RedirectAttributes ra) {
		ArrayList<PostImage> postImages = studyService.selectTimeLineImage(postNo);
		if (postImages != null) {
			for (int i = 0; i < postImages.size(); i++) {
				deleteFile(postImages.get(i).getImgName(), request);
			}
		}
		studyService.deleteTimeLineImgAll(postNo);
		studyService.deleteTimeLine(postNo);

		return "redirect:/study-timeline/board";
	}

	// 댓글 작성
	@RequestMapping(value = "/board/ment", method = RequestMethod.POST)
	public void studyBoardMentInsert(PostComment postComment, HttpServletResponse response)
			throws JsonIOException, IOException {
		studyService.insertMent(postComment);
		PostComment ment = studyService.selectPostCommentOne();
		ment.setMentRegDateString(ment.getMentRegDate().toString());
		Gson gson = new GsonBuilder().create();
		gson.toJson(ment, response.getWriter());
	}

	// 댓글 수정
	@RequestMapping(value = "/board/ment/update", method = RequestMethod.POST)
	@ResponseBody
	public String studyBoardMentUpdate(Model mo, int mentNo, String mentContent, HttpSession session,
			RedirectAttributes ra) {

		int result = studyService.updateMent(mentContent, mentNo);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	// 댓글 삭제
	@RequestMapping(value = "/board/ment/{mentNo}", method = RequestMethod.DELETE)
	@ResponseBody
	public String studyBoardMentDelete(Model mo, @PathVariable("mentNo") int mentNo, HttpSession session,
			RedirectAttributes ra) {
		int result = studyService.deleteMent(mentNo);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	// 최신글이 있는 유저 출력
	@RequestMapping(value = "/board/study-member/{studyNo}", method = RequestMethod.GET)
	public void getMemberList(HttpServletResponse response, @PathVariable("studyNo") int studyNo)
			throws JsonIOException, IOException {
		ArrayList<Student> slist = studyService.getMemberList(studyNo);
		Gson gson = new GsonBuilder().create();
		gson.toJson(slist, response.getWriter());
	}

	// 스터디 생성
	public String studyCreate() {
		return null;
	}

	// 스터디 탈퇴
	@RequestMapping("/study/withdraw")
	public String studyWithdraw(HttpSession session,RedirectAttributes ra,Model mo) {
		Student student = (Student)session.getAttribute("loginStudent");
		studyService.withdrawStudy(student);
		student = studentService.loginStudent(student);
		System.out.println(student.toString());
		mo.addAttribute("loginStudent", student);
		ra.addFlashAttribute("msg", "스터디에서 탈퇴하였습니다.");
		return "redirect:/home";
	}

	// 스터디 해체
	@RequestMapping("/study/disband")
	public String studyDisband(HttpSession session,RedirectAttributes ra,Model mo) {
		Student student = (Student)session.getAttribute("loginStudent");
		studyService.deleteStudy(student.getStudyNo());
		student = studentService.loginStudent(student);
		System.out.println(student.toString());
		mo.addAttribute("loginStudent", student);
		ra.addFlashAttribute("msg", "스터디가 해체되었습니다.");
		return "redirect:/home";
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
