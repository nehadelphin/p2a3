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
    Batch bb = new Batch();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		List<Batch> listOfBatch = bs.findAllBatch();
		pw.println("List of Classes");
		for(int i=0;i<listOfBatch.size();i++) {
			pw.println(listOfBatch.get(i).getBid()+"\t"+listOfBatch.get(i).getClassName());
		}
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		
		String action = request.getParameter("txtUpd");
		if (action.equals("CREATE")) {
			bb.setClassName((request.getParameter("txtName")));
			String result = bs.storeBatch(bb);
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
		bb.setBid(Integer.parseInt(request.getParameter("txtID")));
		bb.setClassName((request.getParameter("txtName")));
		String result = bs.updateBatch(bb);
		request.setAttribute("result", result);
		pw.print(result);
		pw.flush();	
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int bid = Integer.parseInt(request.getParameter("txtID"));
		response.setContentType("text/plain");
		String result = bs.deleteBatch(bid);
		pw.print(result);
		pw.flush();	
	}
}
