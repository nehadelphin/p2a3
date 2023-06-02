package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bean.BatchbyParticipant;
import com.google.gson.Gson;
import com.service.BatchByParticipantService;

public class BatchParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BatchParticipantController() {
        super();

    }
    BatchByParticipantService bs = new BatchByParticipantService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		List<BatchbyParticipant> listOfBatchs = bs.findAllBatchbyParticipant();
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(listOfBatchs);
		pw.print(jsonResponse);
		pw.flush();	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		BufferedReader br = request.getReader();
		response.setContentType("text/plain");
		Gson gson = new Gson();
		BatchbyParticipant BatchbyParticipant = gson.fromJson(br, BatchbyParticipant.class);
		String result = bs.storeBatchbyParticipant(BatchbyParticipant);
		pw.print(result);
		pw.flush();	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/plain");
		String result = bs.deleteBatchbyParticipant(id);
		pw.print(result);
		pw.flush();	
	}

}
