package com.project0part2.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	//create private instance of self
	private static ConnFactory cf;
	//creates private constructor so not publicly accessible
	private ConnFactory() {
		super();
	}
	//thread safe getter
	public static synchronized ConnFactory getInstance() {
		if (cf==null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	//establishes connection to database using database.properties file
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}