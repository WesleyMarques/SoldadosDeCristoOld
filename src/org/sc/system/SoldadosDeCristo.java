package org.sc.system;


import java.awt.EventQueue;

import org.sc.controllers.ConnectionController;
import org.sc.dao.DAOOffline;
import org.sc.dao.DAOOnline;
import org.sc.dao.GenericDAO;
import org.sc.models.User;
import org.sc.models.UserLogin;
import org.sc.views.Window;

public class SoldadosDeCristo {
	
	private static User userLogin = null;
	private static GenericDAO dao = null;
        

	public static void main(String[] args) {
		setDAO();
		//essa Janela vai ser criada pra aparecer a tela inicial
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                
               new Window().setVisible(true);
            }   
            
        });
		

	}
	public static void setDAO(){
		if (ConnectionController.isConnected()) {
			dao = new DAOOnline();			
		}else{
			dao = new DAOOffline();
		}
	}
	
	public static GenericDAO getDAO(){
		setDAO();
		return dao;
	}
	
	public static void setUser(UserLogin us){
		userLogin = us;	
	}
	
	public static User getUser(){
		return userLogin;
	}
	
	

}
