package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bean.Participant;
import com.google.gson.Gson;
import com.service.ParticipantService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParticipantController() {
        super();

    }
    ParticipantService ps = new ParticipantService();
    Participant pp = new Participant();

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		List<Participant> listOfParticipants = ps.findAllParticipant();
		pw.println("List of Participants");
		for(int i=0;i<listOfParticipants.size();i++) {
			if(listOfParticipants.get(i).name.length() <= 7) {
				pw.println(listOfParticipants.get(i).pid+"\t"+listOfParticipants.get(i).name+"\t"+"\t"+listOfParticipants.get(i).email);
			}else {
				pw.println(listOfParticipants.get(i).pid+"\t"+listOfParticipants.get(i).name+"\t"+listOfParticipants.get(i).email);
			}
		}
		pw.flush();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		
		String action = request.getParameter("txtUpd");
		if (action.equals("CREATE")) {
			pp.setName(request.getParameter("txtName"));
			pp.setEmail(request.getParameter("txtEmail"));
			String result = ps.storeParticipant(pp);
			request.setAttribute("result", result);
			pw.print(result);
			pw.flush();	
		}else if(action.equals("UPDATE")) {			
			doPut(request, response);
		}else if(action.equals("DELETE")) {
			doDelete(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pw = response.getWriter();
		pp.setPid(Integer.parseInt(request.getParameter("txtID")));
		pp.setName(request.getParameter("txtName"));
		pp.setEmail(request.getParameter("txtEmail"));
		String result = ps.updateParticipant(pp);
		request.setAttribute("result", result);
		pw.print(result);
		pw.flush();	
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("txtID"));
		response.setContentType("text/plain");
		String result = ps.deleteParticipant(pid);
		pw.print(result);
		pw.flush();			
	}

}
