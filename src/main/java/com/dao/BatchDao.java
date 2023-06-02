package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Batch;
import com.resource.DbResource;
	public class BatchDao {
		Connection con;
		public BatchDao() {
		con = DbResource.getDbConnection();
		}
		public int storeBatch(Batch Batch) {
			try {
			PreparedStatement pstmt = con.prepareStatement("insert into Batch(classname) values (?)");
			pstmt.setString(1, Batch.getClassName());
			return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				return 0;
			}
		}
		public ArrayList<Batch> findAllBatch(){
			ArrayList<Batch> listOfBatch = new ArrayList<>();
			try {
				PreparedStatement pstmt = con.prepareStatement("select * from Batch order by classname");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Batch p = new Batch();
					p.setBid(rs.getInt(1));
					p.setClassName(rs.getString(2));
					listOfBatch.add(p);
				}
				} catch (Exception e) {
					System.out.println(e);
				}
			return listOfBatch;
		}
		public String findBatch(int bid){
			String className = " ";
			try {
				PreparedStatement pstmt = con.prepareStatement("select * from Batch where bid = ?");
				pstmt.setInt(1, bid);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					className = rs.getString(2); 
				}
				} catch (Exception e) {
					System.out.println(e);

				}
			return className;
		}
		public int deleteBatch(int bid) {
			try {
				PreparedStatement pstmt = con.prepareStatement("delete from Batch where bid = ?");
				pstmt.setInt(1, bid);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
		public int updateBatch(Batch Batch) {
			try {
			PreparedStatement pstmt = con.prepareStatement("update batch set classname = ? where bid = ?");
			pstmt.setString(1, Batch.getClassName());
			pstmt.setInt(2, Batch.getBid());
			return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				return 0;
			}
		}
	}