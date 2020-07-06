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
        <div class="container-fluid">
			
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">스터디 보드</h1>
                    </div>

                    <div class="row">




                    </div>

                    <div class="container">
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-lg-12">


                            <!-- Default Card Example -->
                            <div class="card mb-4">
                                <div class="card-header">
                                    <div class="header">
                                        <img class="profile" src="img/chipmunk.jpg">
                                        <div class="writer">
                                            <h5>이승원</h5>
                                            <span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    This card uses Bootstrap's default styling with no utility classes added. Global styles are the only things modifying the look and feel of this default card example.
                                    This card uses Bootstrap's default styling with no utility classes added. Global styles are the only things modifying the look and feel of this default card example.
                                    <div class="img-area row justify-content-center">
                                        <div class="img-box"><img class="content-img" src="img/chipmunk.jpg"></div>
                                        <div class="img-box"><img class="content-img" src="img/chipmunk.jpg"></div>
                                        <div class="img-box"><img class="content-img" src="img/chipmunk.jpg"></div>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="#" data-toggle="modal" data-target="#rWriteModal"><i class="fas fa-comment-dots"></i> 댓글달기</a>
                                    <a href="#"><i class="fas fa-share"></i> 공유하기</a>
                                    <a href="#"><i class="fas fa-pencil-alt"></i> 수정하기</a>
                                    <a href="#"><i class="fas fa-trash-alt"></i> 삭제하기</a>
                                </div>
                                <div class="modal fade" id="rWriteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title" id="exampleModalLabel">댓글 등록</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form>
                                                    <div class="form-group">
                                                        <label for="message-text" class="control-label">작성 내용:</label>
                                                        <textarea rows="5" class="form-control" id="message-text"></textarea>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">작성하기</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <!-- Default Card Example -->
                            <div class="card mb-4">
                                <div class="card-header">
                                    <div class="header">
                                        <img class="profile" src="img/chipmunk.jpg">
                                        <div class="writer">
                                            <h5>이승원</h5>
                                            <span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    This card uses Bootstrap's default styling with no utility classes added. Global styles are the only things modifying the look and feel of this default card example.
                                    This card uses Bootstrap's default styling with no utility classes added. Global styles are the only things modifying the look and feel of this default card example.

                                </div>
                                <div class="card-footer">
                                    <a id="rmodify" href="javascript:void(0);" onclick="rmodify(this);"><i class="fas fa-pencil-alt"></i><span>수정하기</span></a>
                                    <a id="rdelete" href="javascript:void(0);" onclick="rdelete(this);"><i class="fas fa-trash-alt"></i> <span>삭제하기</span></a>
                                    <a id="rcancle" style="display:none;" href="javascript:void(0);" onclick="rcancle(this);"><i class="far fa-arrow-alt-circle-left"></i> <span>취소</span></a>
                                </div>
                            </div>

                            <!-- Default Card Example -->
                            <div class="card mb-4">
                                <div class="card-header">
                                    <div class="header">
                                        <img class="profile" src="img/chipmunk.jpg">
                                        <div class="writer">
                                            <h5>이승원</h5>
                                            <span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">

                                    This card uses Bootstrap's default styling with no utility classes added. Global styles are the only things modifying the look and feel of this default card example.
                                    This card uses Bootstrap's default styling with no utility classes added. Global styles are the only things modifying the look and feel of this default card example.


                                </div>
                                <div class="card-footer">
                                    <a href="#"><i class="fas fa-pencil-alt"></i> 수정하기</a>
                                    <a href="#"><i class="fas fa-trash-alt"></i> 삭제하기</a>
                                </div>
                            </div>


                        </div>

                    </div>
         </div>
      </div>
      <!-- End of Main Content -->
      <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
    </div>
    <!-- End of Content Wrapper -->
  </div>
  <!-- End of Page Wrapper -->
  <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
    <script>
        var text;
        function rmodify(obj) {
            text = $(obj).parent("div").prev("div").text();
            $(obj).children("span").text("수정완료");
            $(obj).parent("div").prev("div").attr('contentEditable', 'true');
            $(obj).siblings("a").eq(0).css("display", "none");
            $(obj).siblings("a").eq(1).css("display", "inline-block");
        }
        function rcancle(obj) {
            $(obj).css("display", "none");
            $(obj).parent("div").prev("div").attr('contentEditable', 'false');
            $(obj).siblings("a").eq(0).children("span").text("수정하기");
            $(obj).siblings("a").eq(1).css("display", "inline-block");
            console.log(text);
            $(obj).parent("div").prev("div").text(text);
        }
    </script>
</body>

</html>
