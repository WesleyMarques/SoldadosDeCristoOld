package org.sc.controllers;

import org.sc.codes.User;
import org.sc.codes.UserLogin;
import org.sc.data.DAO;
import org.sc.data.DAOOffline;
import org.sc.data.NetworkConnect;

public class DataController {

    private DAO dados;

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
     * @return
     * @throws Exception 
     */
    public User searchUserLogin(String email) throws Exception {
        for (User user : dados.loadUsersLogin()) {
            if (((UserLogin) user).getEmail().equals(email)) {
                return user;
            }
        }
        return null;

    }
        //Fim dos métodos para logar um usuário para Login

}
