package com.growbeans.cunity.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView studyBoardList(ModelAndView mv) {
		mv.setViewName("study/boardList");
		return mv;
	}

	// 스터디 타임라인 작성폼
	@RequestMapping("/boardWriteForm")
	public ModelAndView studyBoardWriteForm(ModelAndView mv) {
		mv.setViewName("study/boardWrite");
		return mv;
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
}
