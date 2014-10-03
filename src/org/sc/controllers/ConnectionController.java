package org.sc.controllers;

import org.sc.dao.NetworkConnect;

public class ConnectionController {
	
	public static boolean isConnected() {        
        return NetworkConnect.getTypeConn();
    }

}
