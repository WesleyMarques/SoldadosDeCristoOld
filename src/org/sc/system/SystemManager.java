package org.sc.system;

import org.sc.models.User;
import org.sc.models.UserLogin;
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
    	//try login with data from LOGIN GUI
        User auxLogin = allController.loginActive(email, pw);
        
        //verify if data from loginActive is valid
        if (auxLogin != null) {
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
