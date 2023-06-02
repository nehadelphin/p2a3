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
	
	newpp.setPid(Integer.parseInt(request.getParameter("txtID")));
	newpp.setName(request.getParameter("txtName"));
	newpp.setEmail(request.getParameter("txtEmail"));
	int result = pdao.updateParticipant(newpp);
	if(result > 0){
%>
		<h3>Participant updated</h3>
<%
	}else{
%>
		<h3>Participant not updated</h3>
<%
	}
	ArrayList<Participant> aa = pdao.findAllParticipant();
	session.setAttribute("refparticipants", aa);
%>
</body>
</html>