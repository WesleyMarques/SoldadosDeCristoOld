package org.sc.models;

import java.io.Serializable;

public class UserLogin extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7395479933272131962L;
	private String user = null;
	private String password = null;
	private String email = null;
	
	/**
	 * 
	 * @param user
	 * @param password
	 * @param email
	 * @throws Exception 
	 */
	
	public UserLogin(int registry, String name, String warName, int rG, int battalion, int patent, String status,
			String user, String password, String email) throws Exception{
		super(registry, name, warName, rG, battalion, patent, status);
		if (user == null || password == null || email == null) {
			throw new Exception("Anyone data is wrong, try again!");			
		}
		this.user = user;
		this.password = password;
		this.email = email;		
	}
	/**
	 * @return the user
	 * @throws Exception 
	 */
	public String getUser() throws Exception {
		if (this.user == null) {
			throw new Exception("No UserLogged!");			
		}
		return user;
	}

	/**
	 * @return the password
	 * @throws Exception 
	 */
	public String getPassword() throws Exception {
		if (this.password == null) {
			throw new Exception("No password!");			
		}
		return password;
	}

	/**
	 * @return the email
	 * @throws Exception 
	 */
	public String getEmail() throws Exception {
		if (this.email == null) {
			throw new Exception("No Email!");			
		}
		return email;
	}
	
	/**
     * Verify the email's consistence.
     * @return Boolean of consistence.
     */
    private boolean verifyEmailAddress(String emailAddress){
                return emailAddress.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}") && !emailAddress.equals("");

    }
}
