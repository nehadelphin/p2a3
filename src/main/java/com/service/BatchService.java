package com.service;

import java.util.List;

import com.bean.Batch;
import com.dao.BatchDao;

public class BatchService {
	
	public BatchService() {
		
	}
	BatchDao batch = new BatchDao();

	public String storeBatch(Batch Batch) {
		if(batch.storeBatch(Batch)>0) {
			return "Class data stored";
		}else {
			return "Class data not stored";
		}
	}

	public List<Batch> findAllBatch(){
		return batch.findAllBatch();
	}
	
	public String updateBatch(Batch Batch) {
		if(batch.updateBatch(Batch)>0) {
			return "Class data updated";
		}else {
			return "Class data not updated";
		}
	}
	
	public String deleteBatch(int bid) {
		if(batch.deleteBatch(bid)>0) {
			return "Delete Class Done";
		}else {
			return "Delete Class Unsuccessful";
		}
	}
}
