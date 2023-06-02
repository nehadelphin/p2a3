package com.service;

import java.util.List;

import com.bean.BatchbyParticipant;
import com.dao.BatchbyParticipantDao;

public class BatchByParticipantService {
	
	public BatchByParticipantService() {
		
	}
	BatchbyParticipantDao pd = new BatchbyParticipantDao();

	public String storeBatchbyParticipant(BatchbyParticipant BatchbyParticipant) {
		if(pd.storeBatchbyParticipant(BatchbyParticipant)>0) {
			return "BatchbyParticipant data stored";
		}else {
			return "BatchbyParticipant data not stored";
		}
	}

	public List<BatchbyParticipant> findAllBatchbyParticipant(){
		return pd.findAllBatchbyParticipant();
	}
	
	public String deleteBatchbyParticipant(int id) {
		if(pd.deleteBatchbyParticipant(id)>0) {
			return "Delete BatchbyParticipant Done";
		}else {
			return "Delete BatchbyParticipant Unsuccessful";
		}
	}
}
