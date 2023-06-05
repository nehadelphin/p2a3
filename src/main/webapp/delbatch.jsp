<%@page import="com.dao.BatchDao"%>
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
   	    BatchDao bdao = new BatchDao();
    	ArrayList<Batch> bb = bdao.findAllBatch();
    %>
    <h3>List of Class</h3>
 	<%
   		for(int i=0;i<bb.size();i++) {
			out.println(bb.get(i).getBid()+" "+bb.get(i).getClassName()+"<br>");
		}
	%>
	<h3>Batch to Delete</h3>
	<form action = "Batch" method="post">	
		<input type="hidden" name="txtUpd" value="DELETE"/>	
		Enter Batch ID: <br>
		<input type="text" name="txtID"/><br><br>
		
		<input type="submit" value="Delete">
	</form>
</body>
</html>