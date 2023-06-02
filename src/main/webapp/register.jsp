<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Participant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Participant</title>
</head>
<body>
    <%
    	ArrayList<Participant> pp = (ArrayList<Participant>)session.getAttribute("refparticipants");
    	session.setAttribute("refparticipants", pp);
    %>
	<h3>Participant Details</h3>
	<form action = "participants.jsp" method="post">		
		Enter Name: <br>
		<input type="text" name="txtName"/><br><br>
			
		Enter Email: <br>
		<input type="email" name="txtEmail"/><br><br>
		
		<input type="submit" value="Create">
	</form>
</body>
</html>