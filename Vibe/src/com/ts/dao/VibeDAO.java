package com.ts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.db.VibeConnection;
import com.ts.dto.Admin;

public class VibeDAO {
	public Admin getAdmin(String loginId,String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee where loginId = ? and password = ?";
		try {
			con = VibeConnection.getConnection();
			pst = con.prepareStatement(SELECT);
			pst.setString(1, loginId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setLoginId(rs.getString(3));
				admin.setPassword(rs.getString(4));
				admin.setDept(rs.getString(5));
				return admin;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
