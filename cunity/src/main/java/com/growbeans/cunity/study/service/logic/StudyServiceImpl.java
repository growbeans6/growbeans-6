package com.growbeans.cunity.study.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.PostImage;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.study.domain.Study;
import com.growbeans.cunity.study.service.StudyService;
import com.growbeans.cunity.study.store.StudyStore;

@Service("studyService")
public class StudyServiceImpl implements StudyService{
 
	@Autowired
	private StudyStore studyStore;
	
	@Override
	public int createStudy(Study study) {
		// TODO Auto-generated method stub
		return studyStore.createStudy(study);
	}

	@Override
	public int deleteStudy(int studyNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudyName(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudyManager(Study study) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int joinStudy(Student student) {
		// TODO Auto-generated method stub
		return studyStore.joinStudy(student);
	}
	@Override
	public int deleteApply(int postNo, int studentNo) {
		// TODO Auto-generated method stub
		return studyStore.deleteApply(postNo, studentNo);
	}

	@Override
	public int withdrawStudy(int studentNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Study selectStudy(int studentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> selectStudyStudentList(int studyNo) {
		// TODO Auto-generated method stub
		return studyStore.selectStudyStudentList(studyNo);
	}
	/**
	 * 9. 타임라인 작성
	 * @param post
	 * @return result
	 */
	public int insertTimeLine(Post post) {
		post.setPostContent(post.getPostContent().replace("\n", "<br>"));
		return studyStore.insertTimeLine(post);
	}
	/**
	 * 9-1. 타임라인 이미지 작성
	 * @param postImage
	 * @return result
	 */
	public int insertTimeLineImg(PostImage postImage) {
		return studyStore.insertTimeLineImg(postImage);
		
	}

	@Override
	public ArrayList<Post> selectTimeLineList(int studyNo, String postKinds) {
		// TODO Auto-generated method stub
		return studyStore.selectTimeLineList(studyNo, postKinds);
	}

	@Override
	public Post selectTimeLineDetail(int postNo) {
		// TODO Auto-generated method stub
		return studyStore.selectTimeLineDetail(postNo);
	}
	/**
	 * 11-1. 타임라인 이미지 불러오기
	 * @param postNo
	 * @return
	 */
	public ArrayList<PostImage> selectTimeLineImage(int postNo){
		return studyStore.selectTimeLineImage(postNo);
	}
	@Override
	public int updateTimeLine(Post post) {
		post.setPostContent(post.getPostContent().replace("\n", "<br>"));
		return studyStore.updateTimeLine(post);
	}

	@Override
	public int deleteTimeLine(int postNo) {
		// TODO Auto-generated method stub
		return studyStore.deleteTimeLine(postNo);
	}
	/**
	 * 14. 타임라인 이미지 개별 삭제하기
	 * @param imgNo
	 * @return
	 */
	public int deleteTimeLineImg(int imgNo) {
		return studyStore.deleteTimeLineImg(imgNo);
	}
	
	/**
	 * 15. 타임라인 이미지 전체 삭제하기
	 * @param postNo
	 * @return
	 */
	public int deleteTimeLineImgAll(int postNo) {
		return studyStore.deleteTimeLineImgAll(postNo);
	}

	@Override
	public ArrayList<PostComment> selectPostCommentList(int postNo) {
		// TODO Auto-generated method stub
		return studyStore.selectPostCommentList(postNo);
	}

	@Override
	public int insertMent(PostComment postComment) {
		// TODO Auto-generated method stub
		postComment.setMentContent(postComment.getMentContent().replace("\n", "<br>"));
		return studyStore.insertMent(postComment);
	}

	@Override
	public int updateMent(String mentContent, int mentNo) {
		// TODO Auto-generated method stub
		mentContent = mentContent.replace("\n", "<br>");
		return studyStore.updateMent(mentContent, mentNo);
	}

	@Override
	public int deleteMent(int mentNo) {
		// TODO Auto-generated method stub
		return studyStore.deleteMent(mentNo);
	}

	@Override
	public ArrayList<Student> getMemberList(int studyNo) {
		// TODO Auto-generated method stub
		return studyStore.getMemberList(studyNo);
	}

	@Override
	public PostComment selectPostCommentOne() {
		// TODO Auto-generated method stub
		return studyStore.selectPostCommentOne();
	}

	
}
