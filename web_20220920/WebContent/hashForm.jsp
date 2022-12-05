<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="hashProc.jsp">
		문자열 : <input type="text" name="plainText"><br>
		<input type="radio" name="algorithm" value="MD5"> md5
		<input type="radio" name="algorithm" value="SHA-1"> sha-1
		<input type="radio" name="algorithm" value="SHA-256" checked="checked"> sha-256
		<input type="radio" name="algorithm" value="SHA-384"> sha-384
		<input type="radio" name="algorithm" value="SHA-512"> sha-512<br>
		
		
		<input type="submit" value="해쉬값 구하기">
	</form>
</body>
</html>