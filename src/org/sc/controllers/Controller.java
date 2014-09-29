package org.sc.controllers;

import org.sc.models.User;
import org.sc.models.UserRegistry;

public class Controller {
	private DataController dataController;
	private UserController userController;

	public Controller() {
		dataController = new DataController();
		userController = new UserController();
	}

	public User loginActive(String email, String pw) throws Exception {
		return dataController.searchUserLogin(email, pw);
	}

	public User newUserControll(UserRegistry user) {
		return userController.newRegistry(user);
	}
}
