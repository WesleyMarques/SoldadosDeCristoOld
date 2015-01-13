package org.sc.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PhonesUsers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3403827480521906789L;
	
	private Map<String, String> phones;
	
	public PhonesUsers() {
		phones = new HashMap<String, String>();
	}
	
	private boolean canAddNewPhone(){
		return this.phones.size() < 5;
	}
	
	

}
