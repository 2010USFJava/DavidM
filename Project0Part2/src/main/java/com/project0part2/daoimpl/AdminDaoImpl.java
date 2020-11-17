package com.project0part2.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project0part2.beans.Admin;
import com.project0part2.dao.AdminDao;
import com.project0part2.util.ConnFactory;

public class AdminDaoImpl implements AdminDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void addAdmin(String fName, String lName, String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into admins values (DEFAULT,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.executeUpdate();
	}
	@Override
	public Admin retrieveByID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from admins where admin_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		while(rs.next()) {
			admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		return admin;
	}

	@Override
	public Admin retrieveByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from admins where user_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(4, username);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		while(rs.next()) {
			admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		return admin;
	}
	@Override
	public Admin passwordChecker(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from admins where user_name=? and user_password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		while(rs.next()) {
			admin = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		return admin;
	}

}
