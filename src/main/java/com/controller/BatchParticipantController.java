package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.bean.Batch;
import com.bean.BatchbyParticipant;
import com.bean.Participant;
import com.dao.BatchDao;
import com.dao.BatchbyParticipantDao;
import com.dao.ParticipantDao;
import com.service.BatchByParticipantService;

public class BatchParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BatchParticipantController() {
        super();

    }
    BatchByParticipantService bs = new BatchByParticipantService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		
		BatchbyParticipant bp = new BatchbyParticipant();
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		String foundbid = null; 
		String foundpid = null;
		
		BatchDao bdao = new BatchDao();
		ParticipantDao pdao = new ParticipantDao();
		ArrayList<Batch> ll = bdao.findAllBatch();
		ArrayList<Participant> ll2 = pdao.findAllParticipant();
		
		for(int i=0;i<ll.size();i++) {
				if(ll.get(i).getBid() == bid){
					foundbid = "True";
				}
		}
	    
	    for(int i=0;i<ll2.size();i++) {
				if(ll2.get(i).getPid() == pid){
					foundpid = "True";
				}
			}
	    if (foundbid == "True" & foundpid == "True") {
	    	bp.setBid(bid);
			bp.setPid(pid);
			String result = bs.storeBatchbyParticipant(bp);
			pw.print(result);
			pw.flush();
	    }else {
	    	pw.print("Please enter valid Class ID and Participant ID<");
			pw.flush();
		}
	}
}
