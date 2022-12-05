<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>해쉬값 체크하기</h1>
	<form action="uploadProc.jsp" enctype="multipart/form-data" method="post">
		해쉬값 : <input type="text" name="hash"><br>
		알고르즘 : <input type="radio" name="algorithm" value="MD5"> md5
				<input type="radio" name="algorithm" value="SHA-1"> sha-1
				<input type="radio" name="algorithm" value="SHA-256"> sha-256
				<input type="radio" name="algorithm" value="SHA-384"> sha-384
				<input type="radio" name="algorithm" value="SHA-512" checked="checked"> sha-512<br>
		파일 : <input type="file" name="attachedFile"><br> 
		<input type="submit" value="업로드">
	</form>
</body>
</html>