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

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
	<jsp:include page="../professorwrapper.jsp"></jsp:include>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">

       <jsp:include page="../professorcontent-wrapper.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">상담</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">상담리스트</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>글 번호</th>
                      <th>제목</th>
                      <th>학생이름</th>
                      <th>학번</th>
                      <th>작성일</th>
                      <th>상세조회 및 답변</th>
                      <th>상태</th>
                    </tr>
                  </thead>
                  <tbody style="text-align=center">
                    <c:choose>
                  	<c:when test="${empty proconsultList}">
						<tr>
							<td colspan="8" align="center">등록된 상담이 없습니다.</td>
						</tr>				
					</c:when>
					<c:otherwise>
					<c:forEach items="${proconsultList }" var="list" varStatus="status">
					<tr>
                      <td>${list.cNo }</td>
                      <td>${list.cTitle }</td>
                      <td>${list.sName }</td>
                      <td>${list.sGrade }</td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.cDate }"/></td>
                      
                 
                      <c:url var="proconsultDetail" value="/proconsultDetail">
						<c:param name="cNo" value="${list.cNo }" />
						<c:param name="sName" value="${list.sName }" />
						<c:param name="sNo" value="${list.sNo }"/>
						</c:url>
							
                      <td><a href="${proconsultDetail }">조회</a></td>
                      
                      <c:if test="${list.flag eq 0 }">
                      <td><button  class="btn btn-secondary" disabled>답변 대기</button></td>
                      </c:if>
                        
                      <c:if test="${list.flag eq 1 }">
                      <td><button  class="btn btn-primary" disabled>답변 완료</button></td>
                      </c:if>
                    </tr>	
					</c:forEach>
						</c:otherwise>
					</c:choose>
                  </tbody>
                </table>
                <div>
                
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
