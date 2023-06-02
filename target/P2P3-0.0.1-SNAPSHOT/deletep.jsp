<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ParticipantDao"%>
<%@page import="com.bean.Participant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Participant</title>
</head>
<body>
<%
	Participant newpp = new Participant();
	ParticipantDao pdao = new ParticipantDao();
	
	int pid = Integer.parseInt(request.getParameter("txtID"));
	int result = pdao.deleteParticipant(pid);
	if(result > 0){
%>
		<h3>Participant Deleted</h3>
<%
	}else{
%>
		<h3>Participant not deleted</h3>
<%
	}
	ArrayList<Participant> aa = pdao.findAllParticipant();
	session.setAttribute("refparticipants", aa);
%>
</body>
</html>