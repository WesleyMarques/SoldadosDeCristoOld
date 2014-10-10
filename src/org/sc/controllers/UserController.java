/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sc.controllers;

import org.sc.dao.GenericDAO;
import org.sc.models.User;
import org.sc.system.SoldadosDeCristo;


/**
 *
 * @author Wesley
 */
public class UserController {
    
   
	private static GenericDAO dao;
	
    public static User newUserRegistry(User newUser) throws Exception{
    	dao = SoldadosDeCristo.getDAO();
    	dao.open();
    	dao.persistDataByEntity("", "user");
    	dao.close();
		return newUser;
        /**
         * Para cadastrar a seguinte ordem deve ser respeitada:
         * 1 - Cria quetionário
         * 2 - Cria usuário
         * 3 - cria contatos
         */
        
    }
    
    
    
}
