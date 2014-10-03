package org.sc.controllers;

import org.sc.dao.DAOOffline;
import org.sc.dao.DAOOnline;
import org.sc.dao.GenericDAO;
import org.sc.dao.NetworkConnect;
import org.sc.models.User;
import org.sc.models.UserLogin;

public class DataController {

    private GenericDAO dados;

    public DataController() {
        verifyTypeConn();
    }

    private void verifyTypeConn() {
        if (NetworkConnect.getTypeConn()) {
            dados = new DAOOnline();
        }else{
            dados= new DAOOffline();
        }
    }

    /**
     * 
     * @param email
     * @param pw 
     * @return
     * @throws Exception 
     */
    public User searchUserLogin(String email, String pw) throws Exception {
        for (User user : dados.loadUsers()) {
            if (((UserLogin) user).getEmail().equals(email) && ((UserLogin) user).getPassword().equals(pw)) {
                return user;
            }
        }
        return null;

    }
    //Fim dos métodos para logar um usuário para Login

}
