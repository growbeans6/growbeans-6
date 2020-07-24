<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<style type="text/css">

#dn{
width : 830px;
box-sizing : border-box;
float:left;
}

#lList{
width : 670px;
	float : left;
	box-sizing : border-box;
	margin-left : 100px;
}
#btn1 {
	margin-left : 550px;
}
#btn2 {
	margin-left : 480px;
}
#btn3 {
	margin-left : 1425px;
}
</style>
</head>

<body id="page-top">


  <!-- Page Wrapper -->
  <div id="wrapper" style="overflow:hidden;">
  
  	<c:if test="${judge eq 1}">
    <jsp:include page="wrapper.jsp"></jsp:include>
	</c:if>
	
  	<c:if test="${judge eq 0}">
  		<jsp:include page="professorwrapper.jsp"></jsp:include>
  	</c:if>
  	
    <!-- Content Wrapper -->
    <div id="professorcontent-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
      		<c:if test="${msg ne null}">
      			<script>
      				alert("${msg}");
      			</script>
      		
      		</c:if>
			<c:if test="${judge eq 1}">
       			<jsp:include page="content-wrapper.jsp"></jsp:include>
			</c:if>
			<c:if test="${judge eq 0}">
       			<jsp:include page="professorcontent-wrapper.jsp"></jsp:include>
			</c:if>
        <!-- Begin Page Content -->
        <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
        <div class="container-fluid" >
        <div id="dn">
        
        	<c:url value="/dNoticeList" var="dNoticeList"/>
	        <h4>학과 공지 최신글<a id="btn1" class="btn btn-primary btn-md" href="${dNoticeList }">바로가기</a></h4>
	        
	        <table class="table table-bordered" id="dataTable" style="text-align:center;" >
	                  <thead>
	                    <tr>
	                      <th>글 번호</th>
	                      <th>제목</th>
	                      <th>교수</th>
	                      <th>작성일</th>
	                    </tr>
	                  </thead>
	                  <c:forEach var="i" items="${dnlist }" begin="0" end="4">
	                  <tbody style="text-align=center">
	                    <tr>
	                      <td>${i.dnNo }</td>
	                      <c:url var="dnDetail" value="/dNoticeDetail">
	                      	<c:param name="dnNo" value="${i.dnNo}"></c:param>
	                      </c:url>
	                      <td><a href="${dnDetail }">${i.dnTitle }</a></td>
	                      <td>${i.pName }</td>
	                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${i.dnDate }"/></td>
	                    </tr>
	                  </tbody>
	                  </c:forEach>
	        </table>
        </div>
        
        <div class="table-responsive" id="lList">
        	<c:url value="/prolectureList" var="prolectureList"></c:url>
        	<h4>강의목록<a id="btn2" class="btn btn-primary btn-md" href="${prolectureList }">바로가기</a></h4>
        	<table class="table table-bordered" id="dataTable" >
                  <thead>
                    <tr style="text-align:center">
                      <th>강의명</th>
                      <th>강의실</th>
                      <th>강의요일</th>
                    </tr>
                  </thead>
                  <tbody style="text-align=center">
                  
                  <c:forEach items="${proLecList }" var="list" varStatus="status">
                    <tr style="text-align:center">
                      <td>${list.lName }</td>
                      <td>${list.lroom }</td>
                      <td>${list.lDay1 }(${list.lStartTime1},${list.lEndTime1}),${list.lDay2 }(${list.lStartTime2},${list.lEndTime2})</td>
                    </tr>
                   </c:forEach> 
                   
                  </tbody>
                </table>
        </div>
        
        
        <div class="table-responsive" style="width:100%;">
        		<c:url value="/lectureTime" var="lectureTime"/>
        		<h4>강의시간표<a id="btn3" class="btn btn-primary btn-md" href="${lectureTime }">바로가기</a></h4>
                <table class="table table-bordered" id="dataTable">
                  <thead>

                    <tr>
                      <th></th>
                      <th>월</th>
                      <th>화</th>
                      <th>수</th>
                      <th>목</th>
                      <th>금</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                    <tr>
                      <td>1</td>
                      <td>${timetable.mon1 }</td>
                      <td>${timetable.tue1 }</td>
                      <td>${timetable.wed1 }</td>
                      <td>${timetable.tur1 }</td>
                      <td>${timetable.fri1 }</td>
                    </tr>
                    
                    <tr>
                      <td>2</td>
                      <td>${timetable.mon2 }</td>
                      <td>${timetable.tue2 }</td>
                      <td>${timetable.wed2 }</td>
                      <td>${timetable.tur2 }</td>
                      <td>${timetable.fri2 }</td>
                    </tr>
                    
                    <tr>
                      <td>3</td>
                      <td>${timetable.mon3 }</td> <!-- 월1 -->
                      <td>${timetable.tue3 }</td> <!-- 화1 -->
                      <td>${timetable.wed3 }</td>
                      <td>${timetable.tur3 }</td>
                      <td>${timetable.fri3 }</td>
                    </tr>
                    
                    <tr>
                      <td>4</td>
                      <td>${timetable.mon4 }</td> <!-- 월1 -->
                      <td>${timetable.tue4 }</td> <!-- 화1 -->
                      <td>${timetable.wed4 }</td>
                      <td>${timetable.tur4 }</td>
                      <td>${timetable.fri4 }</td>
                    </tr>
                    
                     <tr>
                      <td>5</td>
                      <td>${timetable.mon5 }</td> <!-- 월1 -->
                      <td>${timetable.tue5 }</td> <!-- 화1 -->
                      <td>${timetable.wed5 }</td>
                      <td>${timetable.tur5 }</td>
                      <td>${timetable.fri5 }</td>
                    </tr>
                    
                    <tr>
                      <td>6</td>
                      <td>${timetable.mon6 }</td> <!-- 월1 -->
                      <td>${timetable.tue6 }</td> <!-- 화1 -->
                      <td>${timetable.wed6 }</td>
                      <td>${timetable.tur6 }</td>
                      <td>${timetable.fri6 }</td>
                    </tr>
                    
                    <tr>
                      <td>7</td>
                      <td>${timetable.mon7 }</td> <!-- 월1 -->
                      <td>${timetable.tue7 }</td> <!-- 화1 -->
                      <td>${timetable.wed7 }</td>
                      <td>${timetable.tur7 }</td>
                      <td>${timetable.fri7 }</td>
                    </tr>                 
                    <tr>
                    </tr>

                  </tbody>
                </table>
              </div>
         </div>
         </div>
      </div>
      <!-- End of Main Content -->
      <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
    </div>
    <!-- End of Content Wrapper -->
  <!-- End of Page Wrapper -->
  
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="/resources/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="/resources/js/demo/chart-area-demo.js"></script>
  <script src="/resources/js/demo/chart-pie-demo.js"></script>
</body>

</html>
