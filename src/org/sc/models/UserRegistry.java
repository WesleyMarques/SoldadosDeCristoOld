package org.sc.models;

import java.io.Serializable;

import org.sc.dao.util.Util;

public class UserRegistry extends User implements Serializable {

   /**
     *
     */
   private static final long serialVersionUID = -8769554218265136933L;
   public static final int MAN = 0;
   public static final int WOMAN = 1;
   public static final int SINGLE = 0;
   public static final int MARRIED = 1;
   public static final int WIDOWED = 2;

   private String photo = null;
   private String documents = null;

   private int gender = -1;
   private String bloodType = null;
   private String CPF = null;
   private String civilStatus = null;
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
   private ContactUsers phones = null;
   private String email = null;
   private QuestionnarieUser questionnarieUser;

   public UserRegistry(int registry, String name, String warName, int rG,
         int battalion, int patent, String status,
         String birthDate, String photo, int sex, String bloodType, String cPF,
         String civilStatus, String schooling,
         String occupation, String nationality, String MPType, String obs,
         String fName, String mName, String street,
         String number, String complement, int zipCode, String district,
         String city, String state, String country,
         ContactUsers phones, String email, QuestionnarieUser qUser)
         throws Exception {
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
      setGender(sex);
      setState(state);
      setStreet(street);
      setZipCode(zipCode);
      // TODO Auto-generated constructor stub
   }

   /**
    * @return the photo
    * @throws UserInvalidException
    */
   public String getPhoto() throws UserInvalidException {
      if (photo == null) {
         throw new UserInvalidException("No photo!");
      }
      return photo;
   }

   /**
    * @param photo
    *           the photo to set
    * @throws Exception
    */
   public void setPhoto(String photo) throws UserInvalidException {
      if (photo == null) {
         throw new UserInvalidException("Photo invalid!");
      }
      this.photo = photo;
   }

   /**
    * @return the gender
    */
   public int getSex() {
      return gender;
   }

   /**
    * @param gender
    *           the gender to set
    * @throws Exception
    */
   public void setGender(int sex) throws UserInvalidException {
      if (sex < 0) {
         throw new UserInvalidException("Gender invalid!");
      }
      this.gender = sex;
   }

   /**
    * @return the bloodType
    * @throws UserInvalidException
    */
   public String getBloodType() throws UserInvalidException {
      if (bloodType == null) {
         throw new UserInvalidException("Bood type invalid!");
      }
      return bloodType;
   }

   /**
    * @param bloodType
    *           the bloodType to set
    * @throws UserInvalidException
    */
   public void setBloodType(String bloodType) throws UserInvalidException {
      if (bloodType == null) {
         throw new UserInvalidException("Your Bood type data is wrong!");
      }
      this.bloodType = bloodType;
   }

   /**
    * @return the cPF
    * @throws UserInvalidException
    */
   public String getCPF() throws UserInvalidException {
      if (CPF == null) {
         throw new UserInvalidException("No CPF inserted!");
      }
      return CPF;
   }

   /**
    * @param cPF
    *           the cPF to set
    */
   public void setCPF(String cPF) throws UserInvalidException {
      if (!Util.validaCPF(cPF)) {
         throw new UserInvalidException("CPF invalid, insert a valid format!");
      }
      CPF = cPF;
   }

   /**
    * @return the civilStatus
    */
   public String getCivilStatus() {
      return civilStatus;
   }

   /**
    * @param civilStatus
    *           the civilStatus to set
    */
   public void setCivilStatus(String civilStatus) throws UserInvalidException {
      if (civilStatus == null || civilStatus == "") {
         throw new UserInvalidException("Civil Status invalid!");
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
    * @param schooling
    *           the schooling to set
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
    * @param occupation
    *           the occupation to set
    */
   public void setOccupation(String occupation) throws UserInvalidException {
      if (occupation == null) {
         throw new UserInvalidException("Occupation invalid!");
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
    * @param birthDate
    *           the birthDate to set
    */
   public void setBirthDate(String birthDate) throws UserInvalidException {
      if (birthDate == null) {
         throw new UserInvalidException("BirthDay invalid!");
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
    * @param nationality
    *           the nationality to set
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
    * @param monthlyPaymentType
    *           the monthlyPaymentType to set
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
    * @param observation
    *           the observation to set
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
    * @param fatherName
    *           the fatherName to set
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
    * @param motherName
    *           the motherName to set
    */
   public void setMotherName(String motherName) throws UserInvalidException {
      if (motherName == null) {
         throw new UserInvalidException("Mother Name invalid!");
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
    * @param street
    *           the street to set
    */
   public void setStreet(String street) throws UserInvalidException {
      if (street == null) {
         throw new UserInvalidException("Street invalid!");
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
    * @param number
    *           the number to set
    */
   public void setNumber(String number) throws UserInvalidException {
      if (number == null) {
         throw new UserInvalidException("Number invalid!");
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
    * @param complement
    *           the complement to set
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
    * @param zipCode
    *           the zipCode to set
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
    * @param district
    *           the district to set
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
    * @param city
    *           the city to set
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
    * @param state
    *           the state to set
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
    * @param country
    *           the country to set
    */
   public void setCountry(String country) {
      this.country = country;
   }

   /**
    * @return the phones
    */
   public ContactUsers getPhones() {
      return phones;
   }

   /**
    * @param phones
    *           the phones to set
    */
   public void setPhones(ContactUsers phones) {
      this.phones = phones;
   }

   /**
    * @return the email
    */
   public String getEmail() {
      return email;
   }

   /**
    * @param email
    *           the email to set
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
