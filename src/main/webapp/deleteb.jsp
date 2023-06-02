<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.BatchDao"%>
<%@page import="com.bean.Batch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Batch</title>
</head>
<body>
<%
	Batch newbb = new Batch();
	BatchDao bdao = new BatchDao();
	
	int bid = Integer.parseInt(request.getParameter("txtID"));
	int result = bdao.deleteBatch(bid);
	if(result > 0){
%>
		<h3>Class Deleted</h3>
<%
	}else{
%>
		<h3>Class not deleted</h3>
<%
	}
	ArrayList<Batch> aa = bdao.findAllBatch();
	session.setAttribute("refbatches", aa);
%>
</body>
</html>