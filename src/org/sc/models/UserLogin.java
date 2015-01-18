package org.sc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "userlogin")
public class UserLogin extends User implements Serializable {

   /**
	 * 
	 */
   private static final long serialVersionUID = -7395479933272131962L;

   @Column(name = "user")
   private String user = null;
   @Column(name = "password")
   private String password = null;
   private String email = null;

   /**
    * 
    * @param user
    * @param password
    * @param email
    * @throws Exception
    */

   public UserLogin(int registry, String name, String warName, int rG,
         int battalion, int patent, String status,
         String user, String password, String email) throws Exception {
      super(registry, name, warName, rG, battalion, patent, status);
      if (user == null || password == null || email == null) {
         throw new Exception("Anyone data is wrong, try again!");
      }
      this.user = user;
      this.password = password;
      this.email = email;
   }

   /**
    * @return the user
    * @throws Exception
    */
   public String getUser() throws Exception {
      if (this.user == null) {
         throw new Exception("No UserLogged!");
      }
      return user;
   }

   /**
    * @return the password
    * @throws Exception
    */
   public String getPassword() throws Exception {
      if (this.password == null) {
         throw new Exception("No password!");
      }
      return password;
   }

   /**
    * @return the email
    * @throws Exception
    */
   public String getEmail() throws Exception {
      if (this.email == null) {
         throw new Exception("No Email!");
      }
      return email;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      return result;
   }

   /*
    * 
    * 
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof UserLogin))
         return false;
      UserLogin other = (UserLogin) obj;
      if (this.email == null) {
         if (other.email != null)
            return false;
      } else if (!this.email.equals(other.email))
         return false;
      return true;
   }

}
