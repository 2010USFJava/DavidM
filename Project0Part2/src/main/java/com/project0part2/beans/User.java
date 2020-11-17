package com.project0part2.beans;

public class User {
	private int userID;
	private String username;
	private String password;
	private String fName;
	private String lName;
	public User() {
		super();
	}
	public User(int userID, String username, String password, String fName, String lName) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + "]";
	}
	
}
