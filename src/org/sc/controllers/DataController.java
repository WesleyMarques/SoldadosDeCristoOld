package org.sc.controllers;

import java.util.List;

import org.sc.codes.UserLogin;
import org.sc.codes.User;
import org.sc.data.DataBaseConnect;
import org.sc.data.DataOffline;
import org.sc.data.DataOnline;

public class DataController {
	
	// M�todos para login do usu�rio
	/**
	 * M�todo principal respons�vel por pegar os dados de login
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public User searchUserLogin(String email) throws Exception {
		if (DataBaseConnect.getTypeConn()) 
			return searchOnlineUser(email);
		return searchOfflineUser(email);

	}
        //Fim dos métodos para logar um usuário para Login
//FIM
        

	/**
	 * Método auxiliar de searchUserLogin para busca Offline
	 * @param email
	 * @return
	 * @throws Exception
	 */
	private User searchOfflineUser(String email) throws Exception {
		for (User user : DataOffline.loadUsersLogin()) {
			if (((UserLogin) user).getEmail().equals(email))
				return user;
		}
		return null;
	}

	/**
	 * Método auxiliar de searchUserLogin para busca Online
	 * @param email
	 * @return
	 * @throws Exception
	 */
	private User searchOnlineUser(String email) throws Exception{
		for (User user : DataOnline.loadUsersLogin()) {
			if (((UserLogin) user).getEmail().equals(email))
				return user;
		}
		return null;
		
	}	
	
}
