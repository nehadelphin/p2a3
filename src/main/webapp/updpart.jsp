<%@page import="com.dao.ParticipantDao"%>
<%@page import="com.bean.Participant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Participant</title>
</head>
<body>
   <%
    	ParticipantDao pdao = new ParticipantDao();
        
   		ArrayList<Participant> pp = pdao.findAllParticipant();
    %>
    <h3>List of Participants</h3>
 	<%
   		for(int i=0;i<pp.size();i++) {
			out.println(pp.get(i).pid+" "+pp.get(i).name+" "+pp.get(i).email+"<br>");
		}
	%>
	<h3>Participant to Update</h3>
	<form action = "Participant" method="post">		
		<input type="hidden" name="txtUpd" value="UPDATE"/>
		Enter Participant ID: <br>
		<input type="text" name="txtID"/><br><br>
		
		Enter Participant Name: <br>
		<input type="text" name="txtName"/><br><br>
			
		Enter Email: <br>
		<input type="email" name="txtEmail"/><br><br>		
		
		<input type="submit" value="Update">
	</form>
</body>
</html>