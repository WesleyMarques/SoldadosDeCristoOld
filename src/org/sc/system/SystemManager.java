package org.sc.system;

import org.sc.codes.User;
import org.sc.codes.UserLogin;
import org.sc.controllers.Controller;
import org.sc.data.NetworkConnect;

public class SystemManager {
    
    private Controller allController = null;
    private User currentUser = null;
    private int typeConnection = -1;
    
    public SystemManager() {
        this.allController = new Controller();
    }
    
    public boolean login(String email, String pw) throws Exception {
        User auxLogin = allController.loginData(email);
        if (auxLogin != null && ((UserLogin) auxLogin).getPassword().equals(pw)) {
            setUserLogin(auxLogin);
            return true;            
        }
        return false;        
    }
    
    public boolean registryUser(User userRegistry){
        //chama allcontrol + userControl para cadastrar new user
        
        return false;
    }
    
    public void setUserLogin(User user) {
        this.currentUser = user;
    }
    
    public User getUserLogin() {
        return this.currentUser;
    }
    
    public Controller getController() {
        return allController;
    }

    //can be used too for refresh connection status
    public boolean getTypeConnection() {        
        return NetworkConnect.getTypeConn();
    }
    
}
