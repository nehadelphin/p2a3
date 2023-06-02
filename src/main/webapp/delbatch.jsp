<%@page import="com.bean.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Class</title>
</head>
<body>
   <%
    	ArrayList<Batch> bb = (ArrayList<Batch>)session.getAttribute("refbatches");
    %>
    <h3>List of Class</h3>
 	<%
   		for(int i=0;i<bb.size();i++) {
			out.println(bb.get(i).getBid()+" "+bb.get(i).getClassName()+"<br>");
		}
	%>
	<h3>Batch to Delete</h3>
	<form action = "deleteb.jsp" method="post">		
		Enter Batch ID: <br>
		<input type="text" name="txtID"/><br><br>
		
		<input type="submit" value="Delete">
	</form>
</body>
</html>