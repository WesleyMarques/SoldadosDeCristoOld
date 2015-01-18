package org.sc.dao;

import java.util.List;
import java.util.Map;

import org.sc.controllers.DataOffController;
import org.sc.models.User;
import org.sc.models.UserLogin;

import com.mysql.jdbc.ResultSet;

/**
 * @author Wesley
 * 
 */
public class DAOOffline implements GenericDAO {

   private static final String LOGIN_USER_DAT_FILE = "loginUser.dat";

   public DAOOffline() {
   }

   @Override
   public boolean open() throws DAOException {
      return true;
   }

   @Override
   public boolean close() throws DAOException {
      return true;
   }

   @Override
   public boolean persistDataByEntity(String newObj, String entity) {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public <T> List<T> findAllByEntityId(String entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public <T> T findByEntityId(String entity, int id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public User findUserLoginByField(String entity, String field,
         String fieldValue) throws DAOException {
      List<User> dataObject;
      try {
         dataObject = DataOffController.getUsers(LOGIN_USER_DAT_FILE);
         System.out.println("ok");
         for (User userList : dataObject) {
            if (((UserLogin) userList).equals(fieldValue)) {
               return userList;
            }
         }
      } catch (DAOException e) {
         throw e;
      } catch (Exception e) {
         throw new DAOException("Usuário não encontrado: " + e.getMessage());
      }

      return null;
   }

   @Override
   public <T> T removeByEntityId(String entidade, int id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public <T> boolean updateByEntityId(String entity, int id, Object newObject) {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public ResultSet query(String query) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int getOperation(String operation, String atribute, String entite)
         throws DAOException {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public boolean queryToOtherCommands(String query) throws DAOException {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public List<Map<String, String>> findAllByColl(String entity,
         String[] colls, String condition) {
      // TODO Auto-generated method stub
      return null;
   }
}
