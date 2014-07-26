package org.sc.controllers;

import org.sc.codes.User;
import org.sc.codes.UserLogin;
import org.sc.data.DAO;
import org.sc.data.DAOOffline;
import org.sc.data.DAOOnline;
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
