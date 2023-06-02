<%@page import="com.dao.BatchbyParticipantDao"%>
<%@page import="com.bean.BatchbyParticipant"%>
<%@page import="com.bean.Participant"%>
<%@page import="com.bean.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Batch> ll = (ArrayList<Batch>)session.getAttribute("refbatches");
	ArrayList<Participant> ll2 = (ArrayList<Participant>)session.getAttribute("refparticipants");
	   
	int bid = Integer.parseInt(request.getParameter("bid"));
	int pid = Integer.parseInt(request.getParameter("pid"));
		   
	String foundbid = null; int saveindexbid = -1;
	String foundpid = null; int saveindexpid = -1;
	
    for(int i=0;i<ll.size();i++) {
			if(ll.get(i).getBid() == bid){
				foundbid = "True";
				saveindexbid = i;
			}
	}
    
    for(int i=0;i<ll2.size();i++) {
			if(ll2.get(i).getPid() == pid){
				foundpid = "True";
				saveindexpid = i;
			}
		}
	if (foundbid == "True" & foundpid == "True"){
			BatchbyParticipant bp = new BatchbyParticipant();
			BatchbyParticipantDao bpdao = new BatchbyParticipantDao();
			bp.setBid(bid);
			bp.setPid(pid);
			int result = bpdao.storeBatchbyParticipant(bp);
			if(result > 0){
%>
				<h3>Participant assigned to class</h3>
<%
			}else{
%>
				<h3>Participant not assigned to class</h3>
<%			
			}
%>
		
<%
	}else {
%>
		<h3>Please enter valid Class ID and Participant ID</h3>
<%
	}    
%>
</body>
</html>