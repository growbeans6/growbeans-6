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
			<br style="clear:both"/>
			<h2 align="center">게시판 등록</h2>
			<br />
			<br />
				<form action="postinsert.kh" method="post" enctype="Multipart/form-data">
					<table align="center" border="1" cellspacing="0">
						<tr>
							<td>제목</td>
							<td><input type="text" size="100" name="postSubject" placeholder="제목을 입력하세요"/></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" name="postWriter" value="${loginUser.userId }" readonly/></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="postContent" cols="50" rows="10" placeholder="내용을 입력해주세요"></textarea></td>
						</tr>
						<tr>
							<td>이미지</td>
							<td><input type="image" src="imgRoot" name="imgName" value="${imgRoot.imgName }"/></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="submit" value="글올리기"/>&nbsp; &nbsp;
								<input type="reset" value="취소"/>
							</td>
						</tr>
					</table>
				</form>	
				
				<p align="center">
					<c:url var="home" value="home.kh" />
					<a href="#">시작페이지</a> &nbsp;
					<c:url var="nlist" value="nlist.kh" />
					<a href="#">목록보기</a>
				</p>
				</div>
        <!-- Begin Page Content -->
        <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
        <div class="container-fluid">

        </div>
      
      <!-- End of Main Content -->
      <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
    </div>
    <!-- End of Content Wrapper -->
  </div>
  <!-- End of Page Wrapper -->
</body>

</html>
