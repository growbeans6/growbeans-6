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
	<jsp:include page="../wrapper.jsp"></jsp:include>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">

       <jsp:include page="../content-wrapper.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
        <!-- Begin Page Content -->
        <!-- Begin Page Content -->
        <div class="container-fluid">

       
       <div class="container text-center">
      </div>
   </div>

   <div class="container">
      <div class="row">
         <div class="col-md-12"></div>
         <div class="col-md-12">
            <h2 class="text-center">${lName } 강의계획서</h2>
               <table class="table table-striped">
                  <tr>
                     <td>강의명</td>
                     <td><input type="text" class="form-control" name="lName" value="${lName }" readonly></td>
                        </tr>
                        
                        <tr>
                     <td>교수명</td>
                     <td><input type="text" class="form-control" name="pName" value="${lpName }"readonly></td>
                  </tr>
                  
                    <tr>
                     <td>연락처</td>
                     <td><input type="text" class="form-control" name="pPhone" value="010 - 3546 - 9420" readonly></td>
                  </tr>

                  <tr>
                     <td>강의 코드</td>
                     <td><input type="text" class="form-control" name="lCode" value="${lecSyl.lCode }"readonly></td>
                  </tr>
                  
                    <tr>
                     <td>교재</td>
                     <td><input type="text" class="form-control" name="lsBook" value="${lecSyl.lsBook }" readonly></td>
                  </tr>

                  <tr>
                     <td>강의 목표</td>
                     <td>
                         <textarea cols="100" rows="10" name="lsGoal">${lecSyl.lsGoal }</textarea>
                     </td>
                  </tr>
                  
                    <tr>
                     <td>강의 내용</td>
                     <td>
                         <textarea cols="100" rows="10" name="lsContent">${lecSyl.lsContent }</textarea>
                     </td>
                  </tr>
                  <tr>
                     <td colspan="2" class="text-center">
                      <c:url var="lectureList" value="/lectureList"></c:url>
                    	<a class="btn btn-primary " href="${lectureList }">수강신청 목록으로</a>
                     </td>
                  </tr>

               </table>
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
