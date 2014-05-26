package org.sc.codes;

import java.io.Serializable;

public class QuestionnarieUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5972881459997081401L;
	public static int NO = 0;
	public static int YES = 1;
	
	
	private int numPeople;
	private String residenceType;
        private String civilStatus;
	private String monthlyIncome;
        private String motherJob;
        private String fatherJob;
        private String howKnowDepartament;
        private int isSmoker;
	private int isAlcoholic;
        
	private int isSick;
	private String whatSick;
	
	private int theFamilyChristian;
	private int theMemberChritian;
	private int theMemberIsSick;
	private String whatTheMemberSick;
	private int isAllergic;
	private String whatsAllergy;
	private int takeMedicine;
	private String whatMedicine;
	
	public QuestionnarieUser() {
		// TODO Auto-generated constructor stub
	}

}
