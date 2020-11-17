package com.project0part2.dao;

import java.sql.SQLException;
import com.project0part2.beans.Admin;

public interface AdminDao {
	public void addAdmin(String fName, String lName, String username, String password) throws SQLException;
	
	public Admin retrieveByID(int id) throws SQLException;
	public Admin retrieveByUsername(String username) throws SQLException;
	public Admin passwordChecker(String username, String password) throws SQLException;
}
