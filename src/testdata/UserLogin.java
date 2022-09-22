package testdata;

import util.Reader;

// POJO to get the value of the username and password's keys

public class UserLogin {
	
	private String username;
	private String password;	
	
	public UserLogin(String fileName) {
		this.username = Reader.json(fileName).get("username").toString();	// returns the value of the username key
		this.password = Reader.json(fileName).get("password").toString();	// returns the value of the password key
	}
		
	public void setUserName(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
		
}