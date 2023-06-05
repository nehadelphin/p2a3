<%@page import="com.dao.ParticipantDao"%>
<%@page import="com.dao.BatchDao"%>
<%@page import="com.bean.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Participant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Participant to Class</title>
</head>
<body>
  <h3>List of Participants</h3>
  <%
   ParticipantDao pdao = new ParticipantDao();
   ArrayList<Participant> ll2 = pdao.findAllParticipant();
   for(int i=0;i<ll2.size();i++) {
		out.println(ll2.get(i).pid+" "+ll2.get(i).name+" "+ll2.get(i).email+"<br>");
	}
  %>
  <h3>List of Classes</h3>
  <%
  BatchDao bdao = new BatchDao();
   ArrayList<Batch> ll = bdao.findAllBatch();
   for(int i=0;i<ll.size();i++) {
		out.println(ll.get(i).getBid()+" "+ll.get(i).getClassName()+"<br>");
	}
  %>
  <br>
  <br>
  <h3>Assign Participant to Class</h3>
  <form action = "BatchParticipantController" method="post">	
  			
		Enter Participant ID: <br>
		<input type="number" name="pid"/><br><br>

		Enter Class ID: <br>
		<input type="number" name="bid"/><br><br>
		
		<input type="submit" value="Assign"><br><br>
	</form>
</body>
</html>