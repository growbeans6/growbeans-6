<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="dninsert.kh" method="post" enctype="Multipart/form-data">
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
				<td><input type="file" name="upfile"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="글올리기"/>&nbsp; &nbsp;
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>