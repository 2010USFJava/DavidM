package com.project0part2.beans;

public class LogBean {
	private String user_name;
	private String log_level;
	private String message;
	public LogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogBean(String user_name, String log_level, String message) {
		super();
		this.user_name = user_name;
		this.log_level = log_level;
		this.message = message;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLog_level() {
		return log_level;
	}
	public void setLog_level(String log_level) {
		this.log_level = log_level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Username: " + user_name + ", Log Type: " + log_level + ", Message: " + message;
	}
	
}
