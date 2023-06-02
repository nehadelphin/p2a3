<%@page import="java.util.List"%>
<%@page import="com.bean.Participant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
  <h3>List of Participants</h3>
  <%
   ArrayList<Participant> ll2 = (ArrayList<Participant>)session.getAttribute("refparticipants");
   for(int i=0;i<ll2.size();i++) {
		out.println(ll2.get(i).pid+" "+ll2.get(i).name+" "+ll2.get(i).email+"<br>");
	}
  %>
</body>
</html>