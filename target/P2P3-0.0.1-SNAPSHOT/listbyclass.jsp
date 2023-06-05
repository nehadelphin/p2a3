<%@page import="com.dao.BatchDao"%>
<%@page import="com.dao.BatchbyParticipantDao"%>
<%@page import="com.bean.BatchbyParticipant"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Classes & Participants</title>
</head>
<body>
  <h3>List of Participants by Classes</h3>
  <%
   String found = null;
   BatchDao bdao = new BatchDao();
   ArrayList<Batch> bb = bdao.findAllBatch();
   BatchbyParticipantDao bpdao = new BatchbyParticipantDao();
   ArrayList<BatchbyParticipant> ll2 = bpdao.findAllBatchbyParticipant();
if (ll2.size() != 0){
	   for(int k=0;k<bb.size();k++) {
		   found = null;
		   out.println("<B>"+bb.get(k).getBid()+" "+bb.get(k).getClassName()+"</B>"+"<br>");
		   for(int i=0;i<ll2.size();i++) {
			 if(bb.get(k).getBid() == ll2.get(i).getBid()){
				 found = "True";
				 out.println(ll2.get(i).toString()+"<br>");
		     }
		   }
		   if(found == null){
			   out.println("No Participants for class<br>");
		   }
		out.println("<br><br>");
	   }
   }else{
	   out.println("No Participants for any class.  Please assign Participants to Class");
   }
  %>
</body>
</html>