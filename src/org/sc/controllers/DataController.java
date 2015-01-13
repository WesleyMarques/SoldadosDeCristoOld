package org.sc.controllers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lavieri.modelutil.cep.WebServiceCep;
import org.sc.dao.DAOException;
import org.sc.dao.GenericDAO;
import org.sc.models.Battalion;
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

   public static int getNewRegistryCode() throws DAOException {
      startDAO();
      int value = dao.getOperation("COUNT", "registry", "user");
      if (value == 0) {
         value = 1;
      } else {
         value = dao.getOperation("MAX", "registry", "user") + 1;
      }

      int newRegistry = (Calendar.getInstance().get(Calendar.YEAR) * 10000)
            + value;
      closeDAO();
      return newRegistry;
   }

   public static String getWarName(String name) {
      return "";
   }

   public static int getNextBattalion(String atribute, String entite)
         throws DAOException {
      startDAO();
      int value = dao.getOperation("COUNT", atribute, entite);
      if (value == 0) {
         value = 1;
      } else {
         value = dao.getOperation("MAX", "numberBat", entite) + 1;
      }
      closeDAO();
      return value;
   }

   public static boolean createNewBattalion(Battalion bat) throws DAOException {

      startDAO();
      if (dao
            .queryToOtherCommands("INSERT INTO battalions (numberBat, street, number, zipCode, city, state, district, country, status) VALUES("
                  + bat.getNumberBat() + ",'" + bat.getStreet() + "','"
                  + bat.getNumber()
                  + "'," + bat.getZipCode() + ",'"
                  + bat.getCity() + "','" + bat.getState() + "','"
                  + bat.getDistrict() + "','" + bat.getCountry() + "','"
                  + bat.getStatus() + "');")) {
         closeDAO();
         return true;
      }
      return false;

   }

   public static List<Map<String, String>> getAllByColl(String[] colls,
         String entity, String condition) throws DAOException {
      startDAO();
      return dao.findAllByColl(entity, colls, condition);
   }

   private static void startDAO() throws DAOException {
      dao = SoldadosDeCristo.getDAO();
      dao.open();
   }

   private static void closeDAO() throws DAOException {
      dao.close();
   }

}
