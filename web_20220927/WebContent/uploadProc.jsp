<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="proSecurity.CyBean"%>

<%
	String saveDirectory = application.getRealPath("/Uploads");
	int maxPostSize = 20 * 1024 * 1000;
	String encoding = "utf-8";
	
	// 1. 파일 업로드
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
	
	//2. 파마미터 정보 받기
	String attachedFile = mr.getOriginalFileName("attachedFile");
	String algorithm = mr.getParameter("algorithm");
	String hash = mr.getParameter("hash");
	String fileFullName = saveDirectory + File.separator + attachedFile;

	//3. 해쉬 값 체크
	CyBean hashCheck = new CyBean();
	boolean res = hashCheck.CheckHash(fileFullName, algorithm, hash);
	
	if(res){
		out.println("해쉬 값이 일치");
	}else{
		out.println("해쉬 값 불일치");
	}
%>


