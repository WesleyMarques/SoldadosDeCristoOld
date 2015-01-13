package org.sc.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sc.dao.DAOException;
import org.sc.dataOff.ReadFiles;
import org.sc.models.User;

public class DataOffController {

   private static ReadFiles readFile;

   public DataOffController() {
   }

   public static List<User> getUsers(String fileName) throws DAOException {
      setInstance();
      List<Object> listUser;
      try {
         listUser = readFile.readData(fileName);
      } catch (IOException e) {
         readFile.loadFile(fileName, new ArrayList<Object>());
         getUsers(fileName);
      } catch (ClassNotFoundException e) {

      }
      return null;
   }

   public static void setInstance() {
      readFile = new ReadFiles();
   }

}
