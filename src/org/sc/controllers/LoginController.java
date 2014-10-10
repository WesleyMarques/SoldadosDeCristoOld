package org.sc.controllers;

import org.sc.dao.GenericDAO;
import org.sc.models.User;
import org.sc.models.UserLogin;
import org.sc.system.SoldadosDeCristo;

public class LoginController {
	
	private static GenericDAO dao;
	
	
	public static boolean login(String user, String password) throws Exception{
		dao = SoldadosDeCristo.getDAO();
		dao.open();
		User userLogin = dao.findUserLoginByField("userlogin", "userName", user);
		dao.close();
		if (userLogin != null) {
			SoldadosDeCristo.setUser((UserLogin)userLogin);
		}else{
			throw new Exception("Usuário não cadastrado!");
		}		
		return true;
	}
	
	public static boolean logout(){
		SoldadosDeCristo.setUser(null);
		return true;
	}
	
	

}
