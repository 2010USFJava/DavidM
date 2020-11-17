package com.project0part2.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0part2.beans.Account;
import com.project0part2.beans.User;
import com.project0part2.dao.AccountDao;
import com.project0part2.util.ConnFactory;

public class AccountDaoImpl implements AccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createAccount(User a, String string, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into accounts values (DEFAULT,?,?,?::NUMERIC,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, string);
		ps.setInt(2, a.getUserID());
		ps.setDouble(3, balance);
		ps.setString(4, a.getUsername());
		ps.executeUpdate();
	}

	@Override
	public Account retrieveAccountByID(int bankAccountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from accounts where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bankAccountID);
		ResultSet rs = ps.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
		}
		return a;
	}

	@Override
	public Account retrieveAccountByUser(User userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from accounts where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID.getUserID());
		ResultSet rs = ps.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
		}
		return a;
	}
	@Override
	public void updateAccount(double balance, int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update accounts set balance=?::NUMERIC where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, balance);
		ps.setInt(2, accountID);
		ps.executeUpdate();
	}

	@Override
	public void deleteAccount(int bankAccountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from accounts where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bankAccountID);
		ps.executeUpdate();
	}

	@Override
	public List<Account> getAllAccounts(int userID) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String sql = "select * from accounts where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getDouble(4));
			accountList.add(a);
		}
		return accountList;
	}
	
}
