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
   ArrayList<Participant> ll2 = (ArrayList<Participant>)session.getAttribute("refparticipants");
   session.setAttribute("refparticipants", ll2);
   for(int i=0;i<ll2.size();i++) {
		out.println(ll2.get(i).pid+" "+ll2.get(i).name+" "+ll2.get(i).email+"<br>");
	}
  %>
  <h3>List of Classes</h3>
  <%
   ArrayList<Batch> ll = (ArrayList<Batch>)session.getAttribute("refbatches");
   session.setAttribute("refbatches", ll);
   for(int i=0;i<ll.size();i++) {
		out.println(ll.get(i).getBid()+" "+ll.get(i).getClassName()+"<br>");
	}
  %>
  <br>
  <br>
  <h3>Assign Participant to Class</h3>
  <form action = "assigntoclass.jsp" method="post">	
  			
		Enter Participant ID: <br>
		<input type="number" name="pid"/><br><br>

		Enter Class ID: <br>
		<input type="number" name="bid"/><br><br>
		
		<input type="submit" value="Assign"><br><br>
		
		<select name="bid">
			<%
			for(int i=0;i<ll.size();i++) {
				int temp = ll.get(i).getBid();
				%>
			  <option value="${i}">${temp}</option>
			<% } %>  
  
		</select>		
	</form>
</body>
</html>