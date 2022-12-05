<%@page language="java" contentType="text/html;charset=euc-kr"  pageEncoding="euc-kr"%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="java.io.*"%>
<%@page import="KISA.SeedCBC"%>
<%@include file="config.jsp"%>
<%
	request.setCharacterEncoding("UTF-8"); // 한글입력을 위한 UTF-8 인코딩 설정
	String sPlainText = request.getParameter( "iPlainText" );
	
	SeedCBC s = new SeedCBC();
	String retMsg = s.LoadConfig(KEY_PATH);
	if (retMsg.equals("OK") == false) {	
		out.print(retMsg);
	} else {
		byte[] bCipherText = s.Encryption(sPlainText.getBytes());
		//byte[] bCipherText = s.Encryption(s.toByteArray(sPlainText));
		BASE64Encoder Base64Encoder = new BASE64Encoder();
	
		out.print(Base64Encoder.encode(bCipherText));
		//out.print(s.toHexString(bCipherText));		
	}
%>