package com.growbeans.cunity.post.domain;

public class Pagination {

	//PageInfo 객체를 리턴해주는 static 메소드 추가
	//PageInfo라는 클래스는 페이징 처리에 필요한 데이터를 담는 클래스, 
	//클래스가 계속 생성이 되면 정보들이 초기화되기 때문에 한번만 생성하여 정보를 저장할 수 있도록 해야함
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		// 페이지 정보를 담아줄 PageInfo 참조변수 선언
		PageInfo pi = null;
		// currentPage와 listCount가 넘어온 상태이기 때문에 
		// 페이징 처리에 필요한 나머지 변수만 선언
		int pageLimit = 10; // 한 페이지에서 보여질 페이징 수
		int maxPage = 5; // 전체 페이징 수 중 가장 마지막 페이지
		int startPage; //현재 페이지에서 보여질 페이징 버튼의 시작 페이지
		int endPage; //현재 페이지에서 보여질 페이징 버튼의 끝 페이지
		
		int boardLimit = 5; // 한 페이지에 보여질 게시글 갯수
		
		//*maxPage - 총 페이지 수
		// 목록 수가 123개이면 10개씩 보여줄 경우 페이지수는 13페이지
		// 짜투리 목록이 최소 1개일 때, 1page로 처리하기 위해 0.9를 더함
		maxPage = (int)((double)listCount / boardLimit + 0.9); // 15/5 = 3.9인데 int라 소수점 버림 3
		
		//*startPage - 현재 페이지에 보여질 시작페이지 수
		//1, 11, 21, 31
		//1, 6, 11
		startPage = (((int)((double)currentPage / pageLimit + 0.9)) - 1) * pageLimit + 1;
		
		
		//*endPage - 현재 페이지에서 보여질 마지막페이지 수
		//10, 20, 30
		endPage = startPage + pageLimit - 1;
		
		//마지막 페이징의 경우 endPage가 maxPage보다 작으니까 이 처리.
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		return pi;
	}
}
