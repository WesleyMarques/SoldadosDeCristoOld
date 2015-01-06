package org.sc.models;

public class Battalion {
   private int idBattalion;
   private String street;
   private int numberBat;
   private int zipCode;
   private String city;
   private String state;
   private String district;
   private String country;
   private String status;
   private String number;

   public Battalion(int id, String street, String status, String country,
         String district, String state, String city, int zip, int numberbat,
         String number) {
      this.idBattalion = id;
      this.street = street;
      this.numberBat = numberbat;
      this.zipCode = zip;
      this.number = number;
      this.city = city;
      this.state = state;
      this.district = district;
      this.country = country;
      this.status = status;
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
   public void setStreet(String street) {
      this.street = street;
   }

   /**
    * @return the number
    */
   public int getNumberBat() {
      return numberBat;
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
   public void setNumber(String number) {
      this.number = number;
   }

   /**
    * @param numberBat
    *           the numberBat to set
    */
   public void setNumberBat(int numberBat) {
      this.numberBat = numberBat;
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
    * @return the status
    */
   public String getStatus() {
      return status;
   }

   /**
    * @param status
    *           the status to set
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /**
    * @return the idBattalion
    */
   public int getIdBattalion() {
      return idBattalion;
   }

}
