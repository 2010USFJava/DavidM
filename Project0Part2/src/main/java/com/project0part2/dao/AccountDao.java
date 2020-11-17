package com.project0part2.dao;

import java.sql.SQLException;
import java.util.List;

import com.project0part2.beans.Account;
import com.project0part2.beans.User;

public interface AccountDao {
	//insert account
	public void createAccount(User a, String string, double balance) throws SQLException;
	//retrieve account
	public Account retrieveAccountByID (int bankAccountID) throws SQLException;
	public Account retrieveAccountByUser(User userID) throws SQLException;
	public void updateAccount(double balance, int accountID) throws SQLException;
	public void deleteAccount(int bankAccountID) throws SQLException;
	public List<Account> getAllAccounts(int userID) throws SQLException;
}
