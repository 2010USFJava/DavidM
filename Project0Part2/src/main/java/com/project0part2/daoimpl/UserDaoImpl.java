package com.project0part2.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project0part2.beans.User;
import com.project0part2.dao.UserDao;
import com.project0part2.util.ConnFactory;

public class UserDaoImpl implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void enterUser(String username, String password, String fName, String lname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into users values(DEFAULT,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, fName);
		ps.setString(4, lname);
		ps.executeUpdate();
	}

	@Override
	public User retrieveByID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from users where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		User user = null;
		while(rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		return user;
	}

	@Override
	public User retrieveByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from users where user_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		User user = null;
		while(rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		return user;
	}

	@Override
	public User retrieveByAccounts(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from users where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountID);
		ResultSet rs = ps.executeQuery();
		User user = null;
		while(rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		return user;
	}
	@Override
	public User passwordChecker(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from users where user_name=? and user_password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		User user = null;
		while(rs.next()) {
			user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		return user;
	}

	@Override
	public void updateUsername(String username, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update users set user_name=? where user_id =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setInt(2, id);
		ps.executeUpdate();
	}

	@Override
	public void updatePassword(String password, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update users set user_password=? where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setInt(2, id);
		ps.executeUpdate();
	}

	@Override
	public void updateFName(String fName, int id) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "update users set f_name=? where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}

	@Override
	public void updateLName(String lName, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update users set l_name=? where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, lName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	@Override
	public void exterminateUser(String username) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "delete from users where user_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.executeUpdate();
	}
}
