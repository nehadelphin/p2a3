package com.service;

import java.util.List;

import com.bean.Participant;
import com.dao.ParticipantDao;

public class ParticipantService {
	
	public ParticipantService() {
		
	}
	ParticipantDao pd = new ParticipantDao();

	public String storeParticipant(Participant Participant) {
		if(pd.storeParticipant(Participant)>0) {
			return "Participant data stored";
		}else {
			return "Participant data not stored";
		}
	}

	public List<Participant> findAllParticipant(){
		return pd.findAllParticipant();
	}
	public String deleteParticipant(int pid) {
		if(pd.deleteParticipant(pid)>0) {
			return "Delete Participant Done";
		}else {
			return "Delete Participant Unsuccessful";
		}
	}
	public String updateParticipant(Participant Participant) {
		if(pd.updateParticipant(Participant)>0) {
			return "Participant data updated";
		}else {
			return "Participant data not updated";
		}
	}
}
