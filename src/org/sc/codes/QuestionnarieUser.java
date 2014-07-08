package org.sc.codes;

import java.io.Serializable;

public class QuestionnarieUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5972881459997081401L;
	public static int NO = 0;
	public static int YES = 1;
        
        //Questionnaire to DSC
        private int isSubmitIntructor;
        private int isRespectFriends;
        private int isBuyUniform;
        private int isDontMiss;
        private int isGiveUniformToOther;
        private int isLearnOath;
        private int isGoodSC;
        private int isSendInvitToFM;
	//FIM
	
        //Questionaire PS
	private int numPeople;
	private String residenceType;
        private String civilStatus;
	private String monthlyIncome;
        private String motherJob;
        private String fatherJob;
        private String howKnowDepartament;
        private String receivedSocialProgram;
	private String whatTheMemberOfSick;
        private String schoolLevelFather;
        private String schoolLevelMother;        
        private int isFamiliarSmoker;
	private int isFalimilarAlcoholic;
        private String familyTakeReligion;
        //FIM
        
        //Questionnaire Personal
        private String yourColor;
        private String whatSick;
        private String whatsAllergy;
	private int takeMedicine;
	private String memberTakeReligion;
        private String whyAreSC;
	private String aboutMedicine;
	//FIM
        

	public QuestionnarieUser() {
		// TODO Auto-generated constructor stub
	}

    public int getIsSubmitIntructor() {
        return isSubmitIntructor;
    }

    public void setIsSubmitIntructor(int isSubmitIntructor) {
        this.isSubmitIntructor = isSubmitIntructor;
    }

    public int getIsRespectFriends() {
        return isRespectFriends;
    }

    public void setIsRespectFriends(int isRespectFriends) {
        this.isRespectFriends = isRespectFriends;
    }

    public int getIsBuyUniform() {
        return isBuyUniform;
    }

    public void setIsBuyUniform(int isBuyUniform) {
        this.isBuyUniform = isBuyUniform;
    }

    public int getIsDontMiss() {
        return isDontMiss;
    }

    public void setIsDontMiss(int isDontMiss) {
        this.isDontMiss = isDontMiss;
    }

    public int getIsGiveUniformToOther() {
        return isGiveUniformToOther;
    }

    public void setIsGiveUniformToOther(int isGiveUniformToOther) {
        this.isGiveUniformToOther = isGiveUniformToOther;
    }

    public int getIsLearnOath() {
        return isLearnOath;
    }

    public void setIsLearnOath(int isLearnOath) {
        this.isLearnOath = isLearnOath;
    }

    public int getIsGoodSC() {
        return isGoodSC;
    }

    public void setIsGoodSC(int isGoodSC) {
        this.isGoodSC = isGoodSC;
    }

    public int getIsSendInvitToFM() {
        return isSendInvitToFM;
    }

    public void setIsSendInvitToFM(int isSendInvitToFM) {
        this.isSendInvitToFM = isSendInvitToFM;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public String getFatherJob() {
        return fatherJob;
    }

    public void setFatherJob(String fatherJob) {
        this.fatherJob = fatherJob;
    }

    public String getHowKnowDepartament() {
        return howKnowDepartament;
    }

    public void setHowKnowDepartament(String howKnowDepartament) {
        this.howKnowDepartament = howKnowDepartament;
    }

    public String getReceivedSocialProgram() {
        return receivedSocialProgram;
    }

    public void setReceivedSocialProgram(String receivedSocialProgram) {
        this.receivedSocialProgram = receivedSocialProgram;
    }

    public String getWhatTheMemberOfSick() {
        return whatTheMemberOfSick;
    }

    public void setWhatTheMemberOfSick(String whatTheMemberOfSick) {
        this.whatTheMemberOfSick = whatTheMemberOfSick;
    }

    public String getSchoolLevelFather() {
        return schoolLevelFather;
    }

    public void setSchoolLevelFather(String schoolLevelFather) {
        this.schoolLevelFather = schoolLevelFather;
    }

    public String getSchoolLevelMother() {
        return schoolLevelMother;
    }

    public void setSchoolLevelMother(String schoolLevelMother) {
        this.schoolLevelMother = schoolLevelMother;
    }

    public int getIsFamiliarSmoker() {
        return isFamiliarSmoker;
    }

    public void setIsFamiliarSmoker(int isFamiliarSmoker) {
        this.isFamiliarSmoker = isFamiliarSmoker;
    }

    public int getIsFalimilarAlcoholic() {
        return isFalimilarAlcoholic;
    }

    public void setIsFalimilarAlcoholic(int isFalimilarAlcoholic) {
        this.isFalimilarAlcoholic = isFalimilarAlcoholic;
    }

    public String getFamilyTakeReligion() {
        return familyTakeReligion;
    }

    public void setFamilyTakeReligion(String familyTakeReligion) {
        this.familyTakeReligion = familyTakeReligion;
    }

    public String getYourColor() {
        return yourColor;
    }

    public void setYourColor(String yourColor) {
        this.yourColor = yourColor;
    }

    public String getWhatSick() {
        return whatSick;
    }

    public void setWhatSick(String whatSick) {
        this.whatSick = whatSick;
    }

    public String getWhatsAllergy() {
        return whatsAllergy;
    }

    public void setWhatsAllergy(String whatsAllergy) {
        this.whatsAllergy = whatsAllergy;
    }

    public int getTakeMedicine() {
        return takeMedicine;
    }

    public void setTakeMedicine(int takeMedicine) {
        this.takeMedicine = takeMedicine;
    }

    public String getMemberTakeReligion() {
        return memberTakeReligion;
    }

    public void setMemberTakeReligion(String memberTakeReligion) {
        this.memberTakeReligion = memberTakeReligion;
    }

    public String getWhyAreSC() {
        return whyAreSC;
    }

    public void setWhyAreSC(String whyAreSC) {
        this.whyAreSC = whyAreSC;
    }

    public String getAboutMedicine() {
        return aboutMedicine;
    }

    public void setAboutMedicine(String aboutMedicine) {
        this.aboutMedicine = aboutMedicine;
    }
        
        

}
