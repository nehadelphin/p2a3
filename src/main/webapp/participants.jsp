<%@page import="com.dao.ParticipantDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Participant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Participant newpp = new Participant();
	ParticipantDao pdao = new ParticipantDao();
	
	newpp.setName(request.getParameter("txtName"));
	newpp.setEmail(request.getParameter("txtEmail"));
	int result = pdao.storeParticipant(newpp);
	if(result > 0){
%>
		<h3>Participant Added</h3>
<%
	}else{
%>
		<h3>Participant not added</h3>
<%
	}
	ArrayList<Participant> aa = pdao.findAllParticipant();
	session.setAttribute("refparticipants", aa);
%>