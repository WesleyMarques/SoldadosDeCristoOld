package org.sc.controllers;

import org.sc.codes.User;

public class Controller {
	private DataController dataController;
        private UserController userController;
	
	public Controller(){
		dataController = new DataController();
                userController = new UserController();
	}
	
	public User loginData(String email) throws Exception{
		return dataController.searchUserLogin(email);
	}
        
        public User newUserControll(User user){
            return userController.newRegistry(user);
        }  
}
