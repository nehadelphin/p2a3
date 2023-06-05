<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Batch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Class</title>
</head>
<body>
	<h3>Class Details</h3>
	<form action = "Batch" method="post">	
		<input type="hidden" name="txtUpd" value="CREATE"/>		
		Enter Class Name: <br>
		<input type="text" name="txtName"/><br><br>
				
		<input type="submit" value="Create">
	</form>
</body>
</html>