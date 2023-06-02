package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bean.Batch;
import com.bean.Participant;
import com.google.gson.Gson;
import com.service.BatchService;

public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BatchController() {
        super();
    }

    BatchService bs = new BatchService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		List<Batch> listOfBatchs = bs.findAllBatch();
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
		Batch Batch = gson.fromJson(br, Batch.class);
		String result = bs.storeBatch(Batch);
		pw.print(result);
		pw.flush();	
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		BufferedReader br = request.getReader();
		response.setContentType("text/plain");
		Gson gson = new Gson();
		Batch Batch = gson.fromJson(br, Batch.class);
		String result = bs.updateBatch(Batch);
		pw.print(result);
		pw.flush();	
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int bid = Integer.parseInt(request.getParameter("bid"));
		response.setContentType("text/plain");
		String result = bs.deleteBatch(bid);
		pw.print(result);
		pw.flush();	
	}
}
