<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script>
function question() {
	var result = window.confirm("정말로 삭제 하시겠습니까?");

	if (result) {
		return true;
	} else {
		return false;
	}

}
</script>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
	<c:choose>
	  	<c:when test="${sessionScope.loginStudent.sNo != null}">
	  		<jsp:include page="../wrapper.jsp"></jsp:include>
	  	</c:when>
	  	<c:otherwise>
	  		<jsp:include page="../professorwrapper.jsp"></jsp:include>
	  	</c:otherwise>
    </c:choose>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">

       <c:choose>
			<c:when test="${sessionScope.loginStudent.sNo != null}">
	       		<jsp:include page="../content-wrapper.jsp"></jsp:include>
	       	</c:when>
			<c:otherwise>
	  			<jsp:include page="../professorcontent-wrapper.jsp"></jsp:include>
	  		</c:otherwise>
	  		
 		</c:choose>

        <!-- Begin Page Content -->
        <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
       <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">학과공지</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">학과공지 게시판</h6>
            </div>
              <div class="input-group mb-3" style="width:65%">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">제목</span>
                </div>
                <div>
                	<span class="input-group-text" id="basic-addon1" style="width:100%;color:black;"><b>${dnDetail.dnTitle}</b></span>
                </div>
              </div>
              <div class="input-group" style="width:65%">
                  <div class="input-group-prepend">
                    <span class="input-group-text">내용</span>
                  </div>
                <div class="form-control" aria-label="With textarea" readonly style="height:100%;color:black;">${dnDetail.dnContent }</div>
              </div>
              <br>
              <c:if test="${ !empty dnDetail.dnFilePath }">
              	<p>첨부파일 : <a href="${contextPath}/resources/dnuploadFiles/${dnDetail.dnFilePath}" download>${dnDetail.dnFilePath }</a></p>
              </c:if>
                <div>
                <br>
                <c:url var="dnList" value="/dNoticeList"></c:url>
                    <a class="btn btn-primary btn-md" href="${dnList }">목록으로</a>
                    <c:url var="dnUpdate" value="/dNoticeUpdateView">
                    	<c:param name="dnNo" value="${dnDetail.dnNo }"/>
                    </c:url>
                    <c:choose>
                    	<c:when test="${sessionScope.loginStudent.sNo == null }">
                    		<c:url var="dnDelete" value="/dNoticeDelete">
                    	<c:param name="dnNo" value="${dnDetail.dnNo }"/>
                    		</c:url>
                    <a class="btn btn-primary btn-md" href="${dnUpdate}">글수정</a>
                    
                    <a onclick="return question();" class="btn btn-secondary btn-md" href="${dnDelete}">글삭제</a>
                    	</c:when>
                    	<c:otherwise>
                    	
                    	</c:otherwise>
                    </c:choose>
                    
                    
                </div>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>

      <!-- End of Main Content -->

      <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
    </div>
    <!-- End of Content Wrapper -->
  </div>
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
