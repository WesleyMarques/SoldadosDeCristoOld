package org.sc.controllers;

import org.sc.dao.GenericDAO;

public class LoginController {
	
	private static GenericDAO dao;
	
	public static boolean login(String user, String password) throws Exception{
		dao.open();
		dao.
		dao.close();
		return true;

	}
	
	public static boolean logout(){
		return true;
	}
	
	

}
