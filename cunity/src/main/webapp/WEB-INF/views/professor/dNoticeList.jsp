<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<style>
div{
overflow : hidden;
}
tr{
text-align:center;
}
</style>


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
          <form action="/dNoticeList" method="post" enctype="multipart/form-data">
          <h1 class="h3 mb-2 text-gray-800">학과공지</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">학과공지 게시판</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-hover" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>글 번호</th>
                      <th>제목</th>
                      <th>교수</th>
                      <th>작성일</th>
                    </tr>
                  </thead>
                  <tbody style="text-align=center">
                  <c:forEach var="dnlist" items="${dnlist }">
                      <c:url var="dnDetail" value="/dNoticeDetail">
                      	<c:param name="dnNo" value="${dnlist.dnNo}"></c:param>
                      </c:url>
                    <tr onclick="location.href='${dnDetail }'">
                      <td>${dnlist.dnNo }</td>
                      <td><a href="${dnDetail}">${dnlist.dnTitle }</a></td>
                      <td>${dnlist.pName }</td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dnlist.dnDate }"/></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <div>
                <c:url value="/dNoticeInsertView" var="dNoticeInsert"></c:url>
                <c:if test="${sessionScope.loginStudent.sNo == null }">
                	<a class="btn btn-primary btn-md" href="${dNoticeInsert }">글쓰기</a>
                </c:if>
                </div>
              </div>
            </div>
            </div>
            </form>
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
    <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/js/demo/datatables-demo.js"></script>
    <script type="text/javascript">
    $('#dataTable').DataTable({
		  order: [[0, 'desc']], // asc 또는 desc
		  ordering: true,
		  serverSide: false
		});
    </script>
</body>

</html>
