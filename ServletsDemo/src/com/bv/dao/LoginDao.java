package com.bv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBConnect;

public class LoginDao {

	public static boolean validateUser(String username, String password) {
		/*
		 * if(username.equals("admin") && password.equals("pass")) return true; return
		 * false;
		 * 
		 */

		String sql = "select username,password from logindetails where username=? and password = ?";
		boolean status = false;
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			status = rs.next();
			if (status) {
				return status;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
