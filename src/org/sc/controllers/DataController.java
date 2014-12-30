package org.sc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.lavieri.modelutil.cep.WebServiceCep;
import org.sc.dao.DAOException;
import org.sc.dao.GenericDAO;
import org.sc.system.SoldadosDeCristo;

public class DataController {

   private static GenericDAO dao;

   public DataController() {
   }

   public static Map<String, String> getLogradouroInfo(String cep)
         throws IllegalArgumentException {
      Map<String, String> info = new HashMap<String, String>();
      if (!ConnectionController.isConnected()) {
         throw new IllegalArgumentException("Sem conexão");
      } else {
         WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
         if (webServiceCep.wasSuccessful()) {
            info.put("logradouro", webServiceCep.getLogradouroFull());
            info.put("cidade", webServiceCep.getCidade());
            info.put("bairro", webServiceCep.getBairro());
            info.put("uf", webServiceCep.getUf());
            info.put("pais", "Brasil");
         }
      }
      return info;
   }

   public static int getNewRegistryCode() {
      return 0;
   }

   public static String getWarName(String name) {
      return "";
   }

   public static int getNextBattalion(String atribute, String entite)
         throws DAOException {
      startDAO();
      int value = dao.getCount(atribute, entite);
      closeDAO();
      return value;
   }

   private static void startDAO() throws DAOException {
      dao = SoldadosDeCristo.getDAO();
      dao.open();
   }

   private static void closeDAO() throws DAOException {
      dao.close();
   }

}
