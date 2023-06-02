<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.BatchDao"%>
<%@page import="com.bean.Batch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Class</title>
</head>
<body>
<%
	Batch newbb = new Batch();
	BatchDao bdao = new BatchDao();
	
	newbb.setBid(Integer.parseInt(request.getParameter("txtID")));
	newbb.setClassName(request.getParameter("txtName"));
	int result = bdao.updateBatch(newbb);
	if(result > 0){
%>
		<h3>Class updated</h3>
<%
	}else{
%>
		<h3>Class not updated</h3>
<%
	}
	ArrayList<Batch> aa = bdao.findAllBatch();
	session.setAttribute("refbatches", aa);
%>
</body>
</html>