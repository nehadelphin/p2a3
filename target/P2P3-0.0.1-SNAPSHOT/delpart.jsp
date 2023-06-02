<%@page import="com.bean.Participant"%>
<%@page import="java.util.ArrayList"%>
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
    	ArrayList<Participant> pp = (ArrayList<Participant>)session.getAttribute("refparticipants");
    %>
    <h3>List of Participants</h3>
 	<%
   		for(int i=0;i<pp.size();i++) {
			out.println(pp.get(i).pid+" "+pp.get(i).name+" "+pp.get(i).email+"<br>");
		}
	%>
	<h3>Participant to Delete</h3>
	<form action = "deletep.jsp" method="post">		
		Enter Participant ID: <br>
		<input type="text" name="txtID"/><br><br>
		
		<input type="submit" value="Delete">
	</form>
</body>
</html>