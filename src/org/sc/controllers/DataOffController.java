package org.sc.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sc.dao.DAOException;
import org.sc.dao.GenericDAO;
import org.sc.dao.streams.NetworkConnect;
import org.sc.dataOff.ReadFiles;
import org.sc.models.Battalion;
import org.sc.models.User;
import org.sc.models.UserLogin;
import org.sc.system.SoldadosDeCristo;

public class DataOffController {

   private static ReadFiles readFile;

   public DataOffController() {
   }

   public static List<User> getUsers(String fileName) throws DAOException {
      setInstance();
      List<Object> listUser;
      List<User> newListUser = new ArrayList<User>();
      try {
         listUser = readFile.readData(fileName);
         for (Object userList : listUser) {
            newListUser.add((UserLogin) userList);
         }
      } catch (ClassNotFoundException | IOException e) {
         if (!(new File("files/" + fileName).exists())) {
            readFile.loadFile(fileName, new ArrayList<Object>());
            getUsers(fileName);
         } else {
            throw new DAOException(e.getMessage());
         }

      }
      return newListUser;
   }

   public static List<Battalion> getBattalions(String fileName)
         throws DAOException {
      setInstance();
      List<Object> listUser;
      List<Battalion> newListUser = new ArrayList<Battalion>();
      try {
         listUser = readFile.readData(fileName);
         System.err.println(listUser.size());
         for (Object userList : listUser) {
            newListUser.add((Battalion) userList);
         }
      } catch (ClassNotFoundException | IOException e) {
         if (!(new File("files/" + fileName).exists())) {
            readFile.loadFile(fileName, new ArrayList<Object>());
            getUsers(fileName);
         } else {
            throw new DAOException(e.getMessage());
         }

      }
      return newListUser;
   }

   public static boolean syncronizedFile() throws DAOException {
      setInstance();
      List<Object> listBat;
      GenericDAO dao = null;
      try {
         listBat = new ArrayList<Object>();
         if (NetworkConnect.getTypeConn()) {
            dao = SoldadosDeCristo.getDAO();
            dao.open();
            for (Object object : dao.findAllByEntityId("battalions")) {
               listBat.add(object);
               System.out.println("aqui" + ((Battalion) object).getCity());
            }
            readFile.saveData("batList.dat", listBat);
         } else {
            // TODO: Não pode realizar a sincronização
         }
      } catch (ClassNotFoundException | IOException e) {
         if (!(new File("files/batList.dat").exists())) {
            readFile.loadFile("batList.dat", new ArrayList<Object>());
            syncronizedFile();
         } else {
            throw new DAOException(e.getMessage());
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         dao.close();
      }
      return false;

   }

   public static void setInstance() {
      readFile = new ReadFiles();
   }

}
