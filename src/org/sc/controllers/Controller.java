package org.sc.controllers;

import org.sc.codes.User;

public class Controller {
	private DataController dataController;
	
	public Controller(){
		dataController = new DataController();
	}
	
	public User loginData(String email) throws Exception{
		return dataController.searchUserLogin(email);
	}
        
        public User registryData(User userRegistry){
            
            return null;
            
        }

}
