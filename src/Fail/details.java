package Fail;

import java.io.Serializable;

public class details implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userId;
	public String Password;
	public String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public details(String userId, String password, String email) {
		super();
		this.userId = userId;
		Password = password;
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
