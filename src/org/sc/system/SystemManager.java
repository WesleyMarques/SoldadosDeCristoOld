package org.sc.system;

import org.sc.controllers.ConnectionController;
import org.sc.models.User;

public class SystemManager {
    
    private User currentUser = null;
    
    
    public SystemManager() {
       
    }
    
    public void setUserLogin(User user) {
        this.currentUser = user;
    }
    
    public User getUserLogin() {
        return this.currentUser;
    }
    
}
