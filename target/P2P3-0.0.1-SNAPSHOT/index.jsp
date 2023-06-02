<%@page import="com.bean.Batch"%>
<%@page import="com.dao.BatchDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Participant"%>
<%@page import="com.dao.ParticipantDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gym Application</title>
</head>
<body>
	<%
		ParticipantDao pdao = new ParticipantDao();
		ArrayList<Participant> participants = pdao.findAllParticipant();
		
		BatchDao bdao = new BatchDao();
		ArrayList<Batch> batches = bdao.findAllBatch();
		
		session.setAttribute("refbatches", batches);
		session.setAttribute("refparticipants", participants);
	%>
	<h1>Delphin's Gym</h1>
	<a href="register.jsp">Register Participant</a><br>
	<a href="updpart.jsp">Update Participant</a><br>
	<a href="delpart.jsp">Delete Participant</a><br>
	<a href="list.jsp">List Participants</a><br>
	<br>
	<a href="createclass.jsp">Create class</a><br>
	<a href="updbatch.jsp">Update Class</a><br>
	<a href="delbatch.jsp">Delete Class</a><br>
	<a href="listclasses.jsp">List Classes</a><br>
	<br>
	<a href="assign.jsp">Assign to Class</a><br>
	<a href="listbyclass.jsp">List Participants by Class</a><br>
</body>
</html>