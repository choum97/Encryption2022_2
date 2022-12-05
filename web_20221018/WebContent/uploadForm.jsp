<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드 ()암호화/복호화)</h1>
	<form action="uploadProc.jsp" enctype="multipart/form-data" method="post">
		유형 : <input type="radio" name="type"  checked="checked" value="encrypt"> 암호화
				<input type="radio" name="type" value="decrypt"> 복호화
		파일 : <input type="file" name="attachedFile"><br> 
		<input type="submit" value="업로드">
	</form>
</body>
</html>