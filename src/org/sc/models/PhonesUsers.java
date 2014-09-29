package org.sc.models;

import java.io.Serializable;

public class PhonesUsers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3403827480521906789L;

	private final int MAX_PHONES = 5;
	
	private int[] phones = new int[MAX_PHONES];
	private String[] typePhones = new String[MAX_PHONES];
	
	public PhonesUsers() {
		// TODO Auto-generated constructor stub
	}

}
