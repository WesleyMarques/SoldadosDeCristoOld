/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sc.controllers;

import org.sc.codes.User;
import org.sc.codes.UserRegistry;
import org.sc.data.DataBaseConnect;

/**
 *
 * @author Wesley
 */
public class UserController {
    
    public User newRegistry(UserRegistry newUser){
        /**
         * Para cadastrar a seguinte ordem deve ser respeitada:
         * 1 - Cria quetionário
         * 2 - Cria usuário
         * 3 - cria contatos
         */
        if(DataBaseConnect.getTypeConn() == DataBaseConnect.ONLINE)
            return newRegistryOnline(newUser);
        return newRegistryOffline(newUser);
    }

    private User newRegistryOnline(UserRegistry newUser) {
        return null;
    }

    private User newRegistryOffline(UserRegistry newUser) {
        return null;
    }
    
}
