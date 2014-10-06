package org.sc.controllers;

import org.sc.dao.GenericDAO;
import org.sc.models.UserLogin;

public class LoginController {
	
	private static GenericDAO dao;
	
	public static boolean login(String user, String password) throws Exception{
		dao.open();
		UserLogin userLogin= dao.findByField("UserLogin", "Email", user);
		dao.close();
		//inserir usuário no usuário da sessão
		return (userLogin != null);
	}
	
	public static boolean logout(){
		return true;
	}
	
	

}
