<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.crypto.KeyGenerator" %>
<%@ page import="javax.crypto.SecretKey" %>
<%@ page import="proSecurity.AesBean"%>
<%
	String pData = request.getParameter("pData");
	String encryptData = request.getParameter("encryptData");
	
	//String decryptText = aes.decrypt(encryptText);
	if(pData != ""){
		AesBean aes = AesBean.getInstance();
		out.print("평문입력  : " + aes.encrypt(pData));
	}
	if(encryptData != "") {
		AesBean aes = AesBean.getInstance();
		out.print("암호문입력 : " + aes.decrypt(encryptData));
	}
%>


