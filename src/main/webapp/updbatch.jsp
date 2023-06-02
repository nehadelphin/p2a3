<%@page import="com.bean.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Class</title>
</head>
<body>
   <%
    	ArrayList<Batch> bb = (ArrayList<Batch>)session.getAttribute("refbatches");
    %>
    <h3>List of Classes</h3>
 	<%
   		for(int i=0;i<bb.size();i++) {
			out.println(bb.get(i).getBid()+" "+bb.get(i).getClassName()+"<br>");
		}
	%>
	<h3>Class to Update</h3>
	<form action = "updateb.jsp" method="put">		
		Enter Class ID: <br>
		<input type="text" name="txtID"/><br><br>
		
		Enter Class Name: <br>
		<input type="text" name="txtName"/><br><br>

		<input type="submit" value="Update">
	</form>
</body>
</html>