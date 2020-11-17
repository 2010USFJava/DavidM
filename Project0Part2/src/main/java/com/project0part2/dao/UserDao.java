package com.project0part2.dao;

import java.sql.SQLException;
import com.project0part2.beans.User;

public interface UserDao {
	public void enterUser(String username, String password, String fName, String lName) throws SQLException;
	
	public User retrieveByID(int id) throws SQLException;
	public User retrieveByUsername(String username) throws SQLException;
	public User retrieveByAccounts(int accountID) throws SQLException;
	public User passwordChecker(String username, String password) throws SQLException;
	public void updateUsername(String username, int id) throws SQLException;
	public void updatePassword(String password, int id) throws SQLException;
	public void updateFName(String fName, int id) throws SQLException;
	public void updateLName(String lName, int id) throws SQLException;
	public void exterminateUser(String username) throws SQLException;
}
