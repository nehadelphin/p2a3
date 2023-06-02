<%@page import="com.dao.BatchDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Batch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Batch> aa = (ArrayList<Batch>)session.getAttribute("refbatches");
	Batch newbb = new Batch();
	BatchDao newdao = new BatchDao();
	
	newbb.setClassName(request.getParameter("txtName"));
	int result = newdao.storeBatch(newbb);
	if(result > 0){
		%>
				<h3>Class Added</h3>
		<%
	}else{
		%>
				<h3>Class not added</h3>
		<%
	}		
			aa = newdao.findAllBatch();
			session.setAttribute("refbatches", aa);
%>