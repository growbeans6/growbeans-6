package com.growbeans.cunity.study.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.PostImage;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.student.mapper.StudentMapper;
import com.growbeans.cunity.student.store.StudentStore;
import com.growbeans.cunity.study.domain.Study;
import com.growbeans.cunity.study.mapper.StudyMapper;
import com.growbeans.cunity.study.store.StudyStore;

@Repository("studyStore")
public class StudyStoreLogic implements StudyStore{
 
	@Autowired
	private SqlSession session;

	@Override
	public int createStudy(Study study) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.createStudy(study);
	}

	@Override
	public int deleteStudy(int studyNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int allWithdrawStudy(int studyNo) {
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
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.joinStudy(student);
	}

	@Override
	public int deleteApply(int postNo, int studentNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.deleteApply(postNo, studentNo);
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
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		
		return mapper.selectStudyStudentList(studyNo);
	}
	/**
	 * 9. 타임라인 작성
	 * @param post
	 * @return result
	 */
	public int insertTimeLine(Post post) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.insertTimeLine(post);
	}
	/**
	 * 9-1. 타임라인 이미지 작성
	 * @param postImage
	 * @return result
	 */
	public int insertTimeLineImg(PostImage postImage) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.insertTimeLineImg(postImage);
		
	}

	@Override
	public ArrayList<Post> selectTimeLineList(int studyNo, String postKinds) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.selectTimeLineList(studyNo, postKinds);
	}

	@Override
	public Post selectTimeLineDetail(int postNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.selectTimeLineDetail(postNo);
	}
	/**
	 * 11-1. 타임라인 이미지 불러오기
	 * @param postNo
	 * @return
	 */
	public ArrayList<PostImage> selectTimeLineImage(int postNo){
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.selectTimeLineImage(postNo);
	}
	@Override
	public int updateTimeLine(Post post) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.updateTimeLine(post);
	}

	@Override
	public int deleteTimeLine(int postNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.deleteTimeLine(postNo);
	}
	/**
	 * 14. 타임라인 이미지 개별 삭제하기
	 * @param imgNo
	 * @return
	 */
	public int deleteTimeLineImg(int imgNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.deleteTimeLineImg(imgNo);
	}
	
	/**
	 * 15. 타임라인 이미지 전체 삭제하기
	 * @param postNo
	 * @return
	 */
	public int deleteTimeLineImgAll(int postNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.deleteTimeLineImgAll(postNo);
	}

	@Override
	public ArrayList<PostComment> selectPostCommentList(int postNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.selectPostCommentList(postNo);
	}

	@Override
	public int insertMent(PostComment postComment) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.insertMent(postComment);
	}

	@Override
	public int updateMent(String mentContent, int mentNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.updateMent(mentContent, mentNo);
	}

	@Override
	public int deleteMent(int mentNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.deleteMent(mentNo);
	}

	@Override
	public ArrayList<Student> getMemberList(int studyNo) {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.getMemberList(studyNo);
	}

	@Override
	public PostComment selectPostCommentOne() {
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		return mapper.selectPostCommentOne();
	}

}
