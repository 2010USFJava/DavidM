package com.project0part2.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0part2.beans.LogBean;
import com.project0part2.dao.LogDao;
import com.project0part2.util.ConnFactory;

public class LogDaoImpl implements LogDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public List<LogBean> getAllAccounts(String username) throws SQLException {
		List<LogBean> logList = new ArrayList<LogBean>();
		Connection conn = cf.getConnection();
		String sql = "select * from logs where user_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		LogBean result = null;
		while(rs.next()) {
			result = new LogBean(rs.getString(1),rs.getString(2),rs.getString(3));
			logList.add(result);
		}
		return logList;
	}

}
