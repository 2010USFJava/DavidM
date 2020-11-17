package com.project0part2.beans;

public class Admin {
	private int adminID;
	private String fName;
	private String lName;
	private String username;
	private String password;
	public Admin() {
		super();
	}
	public Admin(int adminID, String fName, String lName, String username, String password) {
		super();
		this.adminID = adminID;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
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
	@Override
	public String toString() {
		return "Admin ID: " + adminID + ", Name: " + fName + " " + lName + ", Username: " + username
				+ ", Password: " + password;
	}
	
}
