package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Participant;
import com.resource.DbResource;

	public class ParticipantDao {
		Connection con;
		public ParticipantDao() {
		con = DbResource.getDbConnection();
		}

		public int storeParticipant(Participant Participant) {
			try {
			PreparedStatement pstmt = con.prepareStatement("insert into Participant(name,email) values (?,?)");
			pstmt.setString(1, Participant.getName());
			pstmt.setString(2, Participant.getEmail());
			return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				return 0;
			}
		}

		public ArrayList<Participant> findAllParticipant(){
			ArrayList<Participant> listOfParticipant = new ArrayList<>();
			try {
				PreparedStatement pstmt = con.prepareStatement("select * from Participant order by name");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Participant p = new Participant();
					p.setPid(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setEmail(rs.getString(3));
					listOfParticipant.add(p);
				}
				} catch (Exception e) {
					System.out.println(e);

				}
			return listOfParticipant;
		}
		public Participant findParticipant(int pid){
			Participant p = new Participant();
			try {
				PreparedStatement pstmt = con.prepareStatement("select * from participant where pid = ?");
				pstmt.setInt(1, pid);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					p.setPid(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setEmail(rs.getString(3)); 
				}
				} catch (Exception e) {
					System.out.println(e);

				}
			return p;
		}
		public int deleteParticipant(int pid) {
			try {
				PreparedStatement pstmt = con.prepareStatement("delete from Participant where pid = ?");
				pstmt.setInt(1, pid);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
		public int updateParticipant(Participant Participant) {
			try {
				PreparedStatement pstmt = con.prepareStatement("update Participant set name = ?, email = ? where pid = ?");
				pstmt.setString(1, Participant.getName());
				pstmt.setString(2, Participant.getEmail());
				pstmt.setInt(3, Participant.getPid());
				return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
	}

