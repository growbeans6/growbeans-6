package com.growbeans.cunity.study.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.growbeans.cunity.post.domain.Post;
import com.growbeans.cunity.post.domain.PostComment;
import com.growbeans.cunity.post.domain.PostImage;
import com.growbeans.cunity.student.domain.Student;
import com.growbeans.cunity.study.domain.Study;

public interface StudyMapper {
	/**
	 * 1. 스터디 생성
	 * @param study
	 * @return result
	 */
	public int createStudy(Study study);
	
	/**
	 * 2-1. 스터디 해체
	 * @param studyNo
	 * @return result
	 */
	public int deleteStudy(int studyNo);
	
	/**
	 * 2-2. 스터디에 가입된 사람들 전부 탈퇴
	 * @param studyNo
	 * @return result
	 */
	public int allWithdrawStudy(int studyNo);
	
	/**
	 * 3. 스터디 이름 변경
	 * @param study
	 * @return result
	 */
	public int modifyStudyName(Study study);
	
	/**
	 * 4. 스터디 관리자 변경
	 * @param study
	 * @return result
	 */
	public int modifyStudyManager(Study study);
	
	/**
	 * 5-1. 스터디 가입 수락
	 * @param student
	 * @return result
	 */
	public int joinStudy(Student student);
	
	/**
	 * 5-2. 가입신청 댓글 삭제
	 * @param postNo
	 * @param studentNo
	 * @return result
	 */
	public int deleteApply(@Param("postNo") int postNo,@Param("mentWriter") int studentNo);
	
	/**
	 * 6. 스터디 탈퇴
	 * @param studentNo
	 * @return result
	 */
	public int withdrawStudy(int studentNo); 
	
	/**
	 * 7. 스터디 정보 불러오기
	 * @param studentNo
	 * @return study
	 */
	public Study selectStudy(int studentNo);
	
	/**
	 * 8. 스터디 가입자 명단 불러오기
	 * @param studyNo
	 * @return studentList
	 */
	public ArrayList<Student> selectStudyStudentList(int studyNo);
	
	/**
	 * 9. 타임라인 작성
	 * @param post
	 * @return result
	 */
	public int insertTimeLine(Post post);
	/**
	 * 9-1. 타임라인 이미지 작성
	 * @param postImage
	 * @return result
	 */
	public int insertTimeLineImg(PostImage postImage);
	
	/**
	 * 10. 타임라인 리스트 불러오기
	 * @param studyNo
	 * @param postKinds
	 * @return
	 */
	public ArrayList<Post> selectTimeLineList(@Param(value="studyNo") int studyNo,@Param(value="postKinds") String postKinds);
	/**
	 * 11. 타임라인 상세페이지 불러오기
	 * @param postNo
	 * @return
	 */
	public Post selectTimeLineDetail(int postNo);
	/**
	 * 11-1. 타임라인 이미지 불러오기
	 * @param postNo
	 * @return
	 */
	public ArrayList<PostImage> selectTimeLineImage(int postNo);
	/**
	 * 12. 타임라인 수정하기
	 * @param post
	 * @return
	 */
	public int updateTimeLine(Post post);
	/**
	 * 13. 타임라인 삭제하기
	 * @param postNo
	 * @return
	 */
	public int deleteTimeLine(int postNo);
	/**
	 * 14. 타임라인 이미지 개별 삭제하기
	 * @param imgNo
	 * @return
	 */
	public int deleteTimeLineImg(@Param(value="imgNo") int imgNo);
	
	/**
	 * 15. 타임라인 이미지 전체 삭제하기
	 * @param postNo
	 * @return
	 */
	public int deleteTimeLineImgAll(int postNo);
	
	/**
	 * 16. 타임라인 댓글 가져오기
	 * @param postNo
	 * @return
	 */
	public ArrayList<PostComment> selectPostCommentList(int postNo);
	public int insertMent(PostComment postComment);
	public int updateMent(@Param("mentContent") String mentContent,@Param("mentNo") int mentNo);
	public int deleteMent(@Param("mentNo") int mentNo);
	
	/**
	 * 오늘 작성한 타임라인이 있는 유저의 리스트
	 * @param studyNo
	 * @return slist
	 */
	public ArrayList<Student> getMemberList(@Param("studyNo") int studyNo);
	/**
	 * 작성한 댓글 정보 가져오기
	 * @return ment
	 */
	public PostComment selectPostCommentOne();
}
