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
#id{
width="500px";
height = 100%;}

div{
float:left;

}

#dataTable3{
	margin-left : 20px;
}
</style>
</head>

<body id="page-top">


  <!-- Page Wrapper -->
  <div id="wrapper">
  
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
        <div>
        <h2>학과 공지</h2>
        <table class="table table-bordered" id="dataTable" style=width:830px >
                  <thead>
                    <tr>
                      <th>글 번호</th>
                      <th>제목</th>
                      <th>교수</th>
                      <th>작성일</th>
                    </tr>
                  </thead>
                  
                  
                  <c:forEach var="dnlist" items="${dnlist }">
                  <tbody style="text-align=center">
                    <tr>
                      <td>${dnlist.dnNo }</td>
                      <c:url var="dnDetail" value="/dNoticeDetail">
                      	<c:param name="dnNo" value="${dnlist.dnNo}"></c:param>
                      </c:url>
                      <td><a href="${dnDetail }">${dnlist.dnTitle }</a></td>
                      <td>${dnlist.pName }</td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dnlist.dnDate }"/></td>
                    </tr>
                  </tbody>
                  </c:forEach>
                </table>
        </div>
        
        
        <div>
        
        <h2>성적</h2>
        
         <table class="table table-bordered" id="dataTable3" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>이수구분</th>
                      <th>과목명</th>
                      <th>교수명</th>
                      <th>학점</th>
                      <th>과목코드</th>
                      <th>등급</th>
                      <th>평점</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                  
                    <c:forEach items="${lectureEnList }" var="list" varStatus="status">
                    <tr>
                      <td>${list.lClassify }</td>
                      <td>${list.lName }</td>
                      <td>${list.lpName }</td>
                      <td>${list.lPoint }</td>
                      <td>${list.lcode }</td>
                      <td>${gradeList[status.index].sRate }</td>

                      <td>
                      <c:if test="${gradeList[status.index].sRate eq 'A+'}">4.5 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'A'}">4.0 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'B+'}">3.5 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'B'}">3 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'C+'}">2.5 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'C'}">2 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'D+'}">1.5 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'D'}">1 </c:if>
                      <c:if test="${gradeList[status.index].sRate eq 'F'}">0 </c:if>
                      </td>
                    </tr>
                   </c:forEach>
                    <tr>
                    </tr>
                  </tbody>
                </table>
        </div>
        <div class="table-responsive">
        <h2>시간표</h2>
                <table class="table table-bordered" id="dataTable" style=width:50%;>
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
