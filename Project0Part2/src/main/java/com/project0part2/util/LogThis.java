package com.project0part2.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogThis {
	static Logger log = LogManager.getLogger();
	public static ConnFactory cf = ConnFactory.getInstance();
	public static void LogMe(String level, String message, String username) throws IOException, SQLException{
		Connection conn = cf.getConnection();
		switch(level) {
		case "debug":
			log.debug(message);
			break;
		case "warn":
			log.warn(message);
			break;
		case "error":
			log.error(message);
			break;
		case "fatal":
			log.fatal(message);
			break;
		case "info":
			log.info(message);
			break;
		case "trace":
			log.trace(message);
			break;
		default:
			System.err.println("wat");
			break;
		}
		String sql = "insert into logs values (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, level);
		ps.setString(3, message);
		ps.executeUpdate();
	}
}
