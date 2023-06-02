package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Batch;
import com.bean.BatchbyParticipant;
import com.bean.Participant;
import com.resource.DbResource;

	public class BatchbyParticipantDao {
		Connection con;
		public BatchbyParticipantDao() {
		con = DbResource.getDbConnection();
		}

		public int storeBatchbyParticipant(com.bean.BatchbyParticipant batchbyParticipant) {
			try {
			PreparedStatement pstmt = con.prepareStatement("insert into Batchbyparticipant(bid,pid) values (?,?)");
			pstmt.setInt(1, batchbyParticipant.getBid());
			pstmt.setInt(2, batchbyParticipant.getPid());
			return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				return 0;
			}
		}

		public ArrayList<BatchbyParticipant> findAllBatchbyParticipant(){
			ArrayList<BatchbyParticipant> listOfBatchbyParticipant = new ArrayList<>();
			try {
				PreparedStatement pstmt = con.prepareStatement("select * from BatchbyParticipant order by bid, pid");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					BatchbyParticipant p = new BatchbyParticipant();
					String className;
					BatchDao batchDao = new BatchDao();
					Participant participant = new Participant();
					ParticipantDao participantDao = new ParticipantDao();
					int pid;
					int bid;
					
					p.setId(rs.getInt(1));
					bid = rs.getInt(2);
					p.setBid(bid);
					pid = rs.getInt(3);
					p.setPid(pid);
					className = batchDao.findBatch(bid);
					p.setClassName(className);
					participant = participantDao.findParticipant(pid);
					p.setName(participant.getName());
					p.setEmail(participant.getEmail());
					listOfBatchbyParticipant.add(p);
					System.out.println(bid +" " +pid);
				}
				} catch (Exception e) {
					System.out.println(e);

				}
			return listOfBatchbyParticipant;
		}
		
		public int deleteBatchbyParticipant(int id) {
			try {
				PreparedStatement pstmt = con.prepareStatement("delete from BatchbyParticipant where id = ?");
				pstmt.setInt(1, id);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
	}
