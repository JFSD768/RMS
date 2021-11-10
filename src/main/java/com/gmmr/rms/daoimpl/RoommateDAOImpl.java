package com.gmmr.rms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gmmr.rms.dao.RoommateDAO;
import com.gmmr.rms.model.RMSResponseModel;
import com.gmmr.rms.model.Roommate;
import com.gmmr.rms.util.OracleCon;
import com.gmmr.rms.util.RMSException;

public class RoommateDAOImpl //implements RoommateDAO
{
	/*public int addRoommate(Roommate rmt) throws RMSException {
		Connection con = null;
		int status = 0;
		try {
			con = OracleCon.openConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into roommate(no,name,address,mobile,dateOfJoining) values(rmt_seq.nextval,?,?,?,?)");
			ps.setString(1, rmt.getName());
			ps.setString(2, rmt.getAddress());
			ps.setString(3, rmt.getMobile());
			ps.setDate(4, java.sql.Date.valueOf(rmt.getDateOfJoining()));
			status = ps.executeUpdate();
		} catch (Exception e) {
			throw new RMSException("Add Roommate Failed : " + e.getMessage());
		} finally {
			OracleCon.closeConnection(con);
		}
		return status;
	}

	public int editRoommate(Roommate rmt) throws RMSException {
		Connection con = null;
		int status = 0;
		try {
			con = OracleCon.openConnection();
			PreparedStatement ps = con.prepareStatement("update roommate set address=?,mobile=? where no=?");
			ps.setString(1, rmt.getAddress());
			ps.setString(2, rmt.getMobile());
			ps.setInt(3, rmt.getNo());

			status = ps.executeUpdate();
		} catch (Exception e) {
			throw new RMSException("Update Roommate Failed : " + e.getMessage());
		} finally {
			OracleCon.closeConnection(con);
		}
		return status;
	}

	public int delRoommate(Roommate rmt) throws RMSException {
		Connection con = null;
		int status = 0;
		try {
			con = OracleCon.openConnection();
			PreparedStatement ps = con.prepareStatement("delete from roommate where no=?");
			ps.setInt(1, rmt.getNo());
			status = ps.executeUpdate();
		} catch (Exception e) {
			throw new RMSException("Delete Roommate Failed : " + e.getMessage());
		} finally {
			OracleCon.closeConnection(con);
		}
		return status;
	}

	public RMSResponseModel searchRoommate(int roommate_no) throws RMSException {
		Roommate result = null;
		Connection con = null;
		try {
			con = OracleCon.openConnection();
			PreparedStatement ps = con.prepareStatement("select * from roommate where no=?");
			ps.setInt(1, roommate_no);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = new Roommate();
				result.setNo(rs.getInt("no"));
				result.setName(rs.getString("name"));
				result.setAddress(rs.getString("address"));
				result.setMobile(rs.getString("mobile"));
				result.setDateOfJoining(rs.getDate("dateOfJoining").toLocalDate());
			}
		} catch (Exception e) {
			throw new RMSException("Roommate Search Failed : " + e.getMessage());
		} finally {
			OracleCon.closeConnection(con);
		}
		return null;
	}

	public List<Roommate> displayRoommate() throws RMSException {
		List<Roommate> rmtList = null;
		Connection con = null;
		try {
			con = OracleCon.openConnection();
			rmtList = new ArrayList<Roommate>();
			PreparedStatement ps = con.prepareStatement("select * from roommate");
			ResultSet rs = ps.executeQuery();
			/*
			 * if (rs.next()) { Roommate result = new Roommate();
			 * result.setNo(rs.getInt("no"));
			 * result.setName(rs.getString("name"));
			 * result.setAddress(rs.getString("address"));
			 * result.setMobile(rs.getString("mobile"));
			 * result.setDateOfJoining(rs.getDate("dateOfJoining").toLocalDate()
			 * ); rmtList.add(result); }
			 */
			/*printRommate(rs);
		} catch (Exception e) {
			throw new RMSException("Roommate List Retrivel Failed : " + e.getMessage());
		} finally {
			OracleCon.closeConnection(con);
		}
		return rmtList;
	}

	public void printRommate(ResultSet rs) throws SQLException {
		ResultSetMetaData rm = rs.getMetaData();
		int cc = rm.getColumnCount();
		for (int i = 1; i <= cc; i++)
			System.out.print("\t\t" + rm.getColumnName(i));
		System.out.println(" ");
		System.out.println("\t\t---------------------------------------------------------------------------- ");
		while (rs.next()) {
			for (int i = 1; i <= cc; i++)
				System.out.print("\t\t" + rs.getString(i));
			System.out.println("\t\t");
		}
		System.out.println("\t\t---------------------------------------------------------------------------- ");
	}

	public List<Roommate> getAllRoommates() throws RMSException {
		// TODO Auto-generated method stub
		return null;
	}*/
}
