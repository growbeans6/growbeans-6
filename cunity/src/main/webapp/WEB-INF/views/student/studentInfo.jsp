<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <!-- Begin Page Content -->
        <div class="container-fluid">

       
       <div class="container text-center">
      </div>
   </div>

   <div class="container">
      <div class="row">
         <div class="col-md-4"></div>
         <div class="col-md-5">
            <h2 class="text-center">학생정보</h2>
            <br><br>
            <form action="/updateStudentInfo" method="post"
               name="productWrite" enctype="multipart/form-data">
               
               <div style="text-align: center">
               <img src="/resources/img/${loginStudent.sFile }" width="300" height="300">  
               </div>
               
               <table class="table table-striped">
                  <tr>
                     <th>학번</th>
                     <th><input type="text" class="form-control" name="sNo" value="${loginStudent.sNo }" readonly></th>
                     <input type="hidden" name="sFile" value="${loginStudent.sFile }">
                 </tr>
                 

                  <tr>
                     <th>학과</th>
                     <th><input type="text" class="form-control" name="sDept" value="${loginStudent.sDept }"readonly></th>
                  </tr>
                  
                  <tr>
                     <th>이름</th>
                     <th><input type="text" class="form-control" name="sName" value="${loginStudent.sName }"readonly></th>
                  </tr>

                  <tr>
                     <th>전화번호</th>
                     <th><input type="text" class="form-control" name="sPhone" value="${loginStudent.sPhone }"></th>
                  </tr>

                  <tr>
                     <th>주소</th>
                     <th><input type="text" class="form-control" name="sAddress" value="${loginStudent.sAddress }"></th>
                  </tr>

                  <tr>
                     <th>이메일</th>
                     <th><input type="text" class="form-control" name="sEmail" value="${loginStudent.sEmail }"></th>
                  </tr>
                  
                  <tr>
                     <th>학년</th>
                     <th><input type="text" class="form-control" name="sGrade" value="${loginStudent.sGrade }" readonly></th>
                  </tr>


                  <tr>
                     <td colspan="2" class="text-center">
                     	<c:if test="${sessionScope.loginStudent.sNo != null }">
                     		<input type="submit" value="정보수정" class="btn btn-primary"> 
                     	</c:if>
                        <button type="button" class="btn btn-primary" onclick="back()">홈으로</button>
                     </td>
                  </tr>

               </table>
            </form>
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
    <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/js/demo/datatables-demo.js"></script>
</body>

</html>
