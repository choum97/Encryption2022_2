<%@page language="java" contentType="text/html;charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@page import="sun.misc.BASE64Decoder"%>
<%@page import="java.io.*"%>
<%@page import="KISA.SeedCBC"%>
<%@include file="config.jsp"%>
<%
	String sCipherText = request.getParameter( "oCipherText" );
		
	BASE64Decoder Base64Decoder = new BASE64Decoder();
	byte[] bCipherText = Base64Decoder.decodeBuffer( sCipherText );

	SeedCBC s = new SeedCBC();
	String retMsg = s.LoadConfig(KEY_PATH);
	if (retMsg.equals("OK") == false) {	
		out.print(retMsg);
	} else {
		byte[] bPlainText = s.Decryption( bCipherText );
		//byte[] bPlainText = s.Decryption(s.toByteArray(sCipherText));
	
		out.print(new String(bPlainText));
		//out.print(s.toHexString(bPlainText));		
	}
	
%>