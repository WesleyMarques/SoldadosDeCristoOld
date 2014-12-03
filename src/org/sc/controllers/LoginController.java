package org.sc.controllers;

import org.sc.dao.DAOException;
import org.sc.dao.GenericDAO;
import org.sc.models.User;
import org.sc.models.UserInvalidException;
import org.sc.models.UserLogin;
import org.sc.system.SoldadosDeCristo;

public class LoginController {

   private static GenericDAO dao;

   public static boolean login(String user, String password)
         throws UserInvalidException, DAOException {
      startDAO();
      User userLogin = dao.findUserLoginByField("userlogin", "userName", user);
      closeDAO();
      if (userLogin != null) {
         SoldadosDeCristo.setUser((UserLogin) userLogin);
      } else {
         throw new UserInvalidException("Usuário não cadastrado!");
      }
      return true;
   }

   public static boolean logout() {
      SoldadosDeCristo.setUser(null);
      return true;
   }

   private static void startDAO() throws DAOException {
      dao = SoldadosDeCristo.getDAO();
      dao.open();
   }

   private static void closeDAO() throws DAOException {
      dao.close();
   }

}
