package com.project0part2.dao;

import java.sql.SQLException;
import java.util.List;

import com.project0part2.beans.LogBean;

public interface LogDao {
	public List<LogBean> getAllAccounts(String username) throws SQLException;
}
