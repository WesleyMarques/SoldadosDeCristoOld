package org.sc.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactUsers implements Serializable {

   /**
	 * 
	 */
   private static final long serialVersionUID = -3403827480521906789L;

   private Map<String, List> contacts;

   public ContactUsers() {
      contacts = new HashMap<String, List>();
   }

   public void add(String chave, String key, String... obs) {
      List<Object> list = new ArrayList<>();
      for (String contact : obs) {
         list.add(contact);
      }
      contacts.put(chave, list);
   }

}
