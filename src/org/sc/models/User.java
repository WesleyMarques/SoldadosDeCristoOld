package org.sc.models;

import java.io.Serializable;

public class User implements Serializable {

   /**
	 * 
	 */
   private static final long serialVersionUID = -8210551665835499908L;
   // Atributos da classe
   private int registry = 0;
   private String name = null;
   private String warName = null;
   private int RG = 0;
   private int battalion = -1;
   private int patent = 0;
   private String status = null;

   public User(int registry, String name, String warName, int rG,
         int battalion, int patent, String status) throws Exception {
      setName(name);
      setWarName(warName);
      setRegistry(registry);
      setBattalion(battalion);
      setPatent(patent);
      setRG(rG);
      setStatus(status);
   }

   /**
    * @return the registry
    * @throws Exception
    */
   public int getRegistry() throws UserInvalidException {
      if (this.registry == 0) {
         throw new UserInvalidException("No Registry!");
      }
      return registry;
   }

   /**
    * @param registry
    *           the registry to set
    * @throws Exception
    */
   public void setRegistry(int registry) throws UserInvalidException {
      if (registry == 0) {
         throw new UserInvalidException("Registry value is wrong!");
      }
      this.registry = registry;
   }

   /**
    * @return the name
    * @throws Exception
    */
   public String getName() throws UserInvalidException {
      if (this.name == null) {
         throw new UserInvalidException("No Name!");
      }
      return name;
   }

   /**
    * @param name
    *           the name to set
    * @throws Exception
    */
   public void setName(String name) throws UserInvalidException {
      if (name == null) {
         throw new UserInvalidException("Your name is wrong!");
      }
      this.name = name;
   }

   /**
    * @return the warName
    * @throws Exception
    */
   public String getWarName() throws UserInvalidException {
      if (this.warName == null) {
         throw new UserInvalidException("No War Name!");
      }
      return warName;
   }

   /**
    * @param warName
    *           the warName to set
    * @throws Exception
    */
   public void setWarName(String warName) throws UserInvalidException {
      if (warName == null) {
         throw new UserInvalidException("Your war name is wrong!");
      }
      this.warName = warName;
   }

   /**
    * @return the rG
    * @throws Exception
    */
   public int getRG() throws UserInvalidException {
      if (this.RG == 0) {
         throw new UserInvalidException("No RG inserted!");
      }
      return RG;
   }

   /**
    * @param rG
    *           the rG to set
    * @throws Exception
    */
   public void setRG(int rG) throws UserInvalidException {
      if (rG == 0) {
         throw new UserInvalidException("Your RG format is wrong!");
      }
      this.RG = rG;
   }

   /**
    * @return the battalion
    * @throws Exception
    */
   public int getBattalion() throws UserInvalidException {
      if (this.battalion == 0) {
         throw new UserInvalidException("No Battalion!");
      }
      return battalion;
   }

   /**
    * @param battalion
    *           the battalion to set
    * @throws Exception
    */
   public void setBattalion(int battalion) throws UserInvalidException {
      if (battalion == 0) {
         throw new UserInvalidException("Battalion value is wrong!");
      }
      this.battalion = battalion;
   }

   /**
    * @return the patent
    * @throws Exception
    */
   public int getPatent() throws UserInvalidException {
      if (this.patent == 0) {
         throw new UserInvalidException("No Patent!");
      }
      return patent;
   }

   /**
    * @param patent
    *           the patent to set
    * @throws Exception
    */
   public void setPatent(int patent) throws UserInvalidException {
      if (patent == 0) {
         throw new UserInvalidException("Patent value is wrong, try again!");
      }
      this.patent = patent;
   }

   /**
    * @return the status
    * @throws Exception
    */
   public String getStatus() throws UserInvalidException {
      if (this.status == null) {
         throw new UserInvalidException("No Status!");
      }
      return this.status;
   }

   /**
    * @param status
    *           the status to set
    * @throws Exception
    */
   public void setStatus(String status) throws UserInvalidException {
      if (status == null) {
         throw new UserInvalidException("Your status value is wrong!");
      }
      this.status = status;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      User other = (User) obj;
      if (registry != other.registry)
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "User [registry=" + registry + ", name=" + name + "]";
   }

}
