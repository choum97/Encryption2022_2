<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="security.Hash"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String plainText = request.getParameter("plainText");
		String algorithm = request.getParameter("algorithm");
		Hash hash = new Hash();
			
		String md = hash.getHash(plainText, algorithm);
	%>
	plainText : <%=plainText %><br>
	algorithm : <%=algorithm %> <br>
	Message Digest : <%=md %>
</body>
</html>