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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		List<Participant> listOfParticipants = ps.findAllParticipant();
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(listOfParticipants);
		pw.print(jsonResponse);
		pw.flush();	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		BufferedReader br = request.getReader();
		response.setContentType("text/plain");
		Gson gson = new Gson();
		Participant Participant = gson.fromJson(br, Participant.class);
		String result = ps.storeParticipant(Participant);
		pw.print(result);
		pw.flush();	
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		BufferedReader br = request.getReader();
		response.setContentType("text/plain");
		Gson gson = new Gson();
		Participant Participant = gson.fromJson(br, Participant.class);
		String result = ps.updateParticipant(Participant);
		pw.print(result);
		pw.flush();
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		response.setContentType("text/plain");
		String result = ps.deleteParticipant(pid);
		pw.print(result);
		pw.flush();	
		
	}

}
