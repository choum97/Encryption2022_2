<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="proSecurity.CyBean"%>

<%
	String saveDirectory = application.getRealPath("/upload");
	/*
		C:/Users/KM/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/web_20221018/upload
	*/
	int maxPostSize = 10 * 1024 * 1024;
	String encoding = "utf-8";
	
	
	// 1. 파일 업로드
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
	
	//form 값 받기
	String type = mr.getParameter("type");
	String attachedFile = mr.getParameter("attachedFile");
	
	String fileFullName = saveDirectory + File.separator + attachedFile;
	File file = new File(fileFullName);
	
	/*
	int index1 = fileFullName.lastIndexOf("\\");
	int index2 = fileFullName.lastIndexOf('.');
	String tmpFileName1 = fileFullName.substring(0, index1+1) + "encrypt" + fileFullName.substring(index2);
	String tmpFileName2 = fileFullName.substring(0, index1+1) + "decrypt" + fileFullName.substring(index2);
	*/
	
	if(type.equals("encrypt")){
		CyBean cyBean = CyBean.getInstance();
		cyBean.Encrypt(fileFullName);
	}
	if(type.equals("decrypt")){
		CyBean cyBean = CyBean.getInstance();
		cyBean.Decrypt(fileFullName);
	}
	
%>


