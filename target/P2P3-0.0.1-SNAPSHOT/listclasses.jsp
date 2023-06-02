<%@page import="java.util.List"%>
<%@page import="com.bean.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Classes</title>
</head>
<body>
  <h3>List of Classes</h3>
  <%
   ArrayList<Batch> ll2 = (ArrayList<Batch>)session.getAttribute("refbatches");
   for(int i=0;i<ll2.size();i++) {
		out.println(ll2.get(i).getBid()+" "+ll2.get(i).getClassName()+"<br>");
	}
  %>
</body>
</html>