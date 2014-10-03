package org.sc.models;

import java.io.Serializable;

public class UserRegistry extends User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8769554218265136933L;
    private static final int MAN = 0;
    private static final int WOMAN = 1;
    private static final int SINGLE = 0;
    private static final int MARRIED = 1;
    private static final int WIDOWED = 2;

    private String photo = null;
    private String documents = null;
    
    private int sex = -1;   
    private String bloodType = null;
    private int CPF = 0;
    private int civilStatus = -1;
    private String schooling = null;
    private String occupation = null;
    private String birthDate = null;
    private String nationality = null;
    private String monthlyPaymentType = null;
    private String observation = null;
    private String fatherName = null;
    private String motherName = null;
    private String street = null;
    private String number = null;
    private String complement = null;
    private int zipCode = 0;
    private String district = null;
    private String city = null;
    private String state = null;
    private String country = null;
    private PhonesUsers phones = null;
    private String email = null;
    private QuestionnarieUser questionnarieUser;
    
    

    public UserRegistry(int registry, String name, String warName, int rG, int battalion, int patent, String status,
            String birthDate, String photo, int sex, String bloodType, int cPF, int civilStatus, String schooling,
            String occupation, String nationality, String MPType, String obs, String fName, String mName, String street,
            String number, String complement, int zipCode, String district, String city, String state, String country,
            PhonesUsers phones, String email, QuestionnarieUser qUser) throws Exception {
        super(registry, name, warName, rG, battalion, patent, status);
        setBirthDate(birthDate);
        setBloodType(bloodType);
        setCity(city);
        setCivilStatus(civilStatus);
        setComplement(complement);
        setCountry(country);
        setCPF(cPF);
        setDistrict(district);
        setEmail(email);
        setFatherName(fName);
        setMonthlyPaymentType(MPType);
        setMotherName(mName);
        setNationality(nationality);
        setNumber(number);
        setObservation(obs);
        setOccupation(occupation);
        setPhones(phones);
        setPhoto(photo);
        setSchooling(schooling);
        setSex(sex);
        setState(state);
        setStreet(street);
        setZipCode(zipCode);
        // TODO Auto-generated constructor stub
    }


    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     * @throws Exception
     */
    public void setPhoto(String photo) throws Exception {
        if (photo == null) {
            throw new Exception("Data invalid!");
        }
        this.photo = photo;
    }

    /**
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     * @throws Exception
     */
    public void setSex(int sex) throws Exception {
        if (sex < 0) {
            throw new Exception("Data invalid!");
        }
        this.sex = sex;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return the cPF
     */
    public int getCPF() {
        return CPF;
    }

    /**
     * @param cPF the cPF to set
     */
    public void setCPF(int cPF) throws Exception {
        if (!validaCPF(cPF+"")) {
            throw new Exception("Data invalid!");
        }
        CPF = cPF;
    }

    private boolean validaCPF(String strCpf) {
        int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
        int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
        String strDigitoVerificador, strDigitoResultado;

        if (!strCpf.substring(0, 1).equals("")) {
            try {
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                for (int iCont = 1; iCont < strCpf.length() - 1; iCont++) {
                    iDigitoCPF = Integer.valueOf(strCpf.substring(iCont - 1, iCont)).intValue();
                    iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
                    iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
                }
                iRestoDivisao = (iDigito1Aux % 11);
                if (iRestoDivisao < 2) {
                    iDigito1 = 0;
                } else {
                    iDigito1 = 11 - iRestoDivisao;
                }
                iDigito2Aux += 2 * iDigito1;
                iRestoDivisao = (iDigito2Aux % 11);
                if (iRestoDivisao < 2) {
                    iDigito2 = 0;
                } else {
                    iDigito2 = 11 - iRestoDivisao;
                }
                strDigitoVerificador = strCpf.substring(strCpf.length() - 2, strCpf.length());
                strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
                return strDigitoVerificador.equals(strDigitoResultado);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @return the civilStatus
     */
    public int getCivilStatus() {
        return civilStatus;
    }

    /**
     * @param civilStatus the civilStatus to set
     */
    public void setCivilStatus(int civilStatus) throws Exception {
        if (sex == -1) {
            throw new Exception("Data invalid!");
        }
        this.civilStatus = civilStatus;
    }

    /**
     * @return the schooling
     */
    public String getSchooling() {
        return schooling;
    }

    /**
     * @param schooling the schooling to set
     */
    public void setSchooling(String schooling) {
        this.schooling = schooling;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) throws Exception {
        if (occupation == null) {
            throw new Exception("Data invalid!");
        }
        this.occupation = occupation;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) throws Exception {
        if (birthDate == null) {
            throw new Exception("Data invalid!");
        }
        this.birthDate = birthDate;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the monthlyPaymentType
     */
    public String getMonthlyPaymentType() {
        return monthlyPaymentType;
    }

    /**
     * @param monthlyPaymentType the monthlyPaymentType to set
     */
    public void setMonthlyPaymentType(String monthlyPaymentType) {
        this.monthlyPaymentType = monthlyPaymentType;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) throws Exception {
        if (motherName == null) {
            throw new Exception("Data invalid!");
        }
        this.motherName = motherName;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) throws Exception {
        if (street == null) {
            throw new Exception("Data invalid!");
        }
        this.street = street;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) throws Exception {
        if (number == null) {
            throw new Exception("Data invalid!");
        }
        this.number = number;
    }

    /**
     * @return the complement
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement the complement to set
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * @return the zipCode
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the phones
     */
    public PhonesUsers getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(PhonesUsers phones) {
        this.phones = phones;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * @return 
     */
    public String getDocuments() {
        return documents;
    }

    /**
     * 
     * 
     * @return 
     */
    public QuestionnarieUser getQuestionnarieUser() {
        return questionnarieUser;
    }

}
