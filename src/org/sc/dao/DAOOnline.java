/**
 * this class is responsible to create a connection online with the database the
 * data base is a server: name: mysql07.soldadosdecristo2.hospedagemdesites.ws
 * user:soldadosdecris8@186.202.28.226 password:t1moteo23.
 */
package org.sc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sc.dao.mysql.ConnectionMySql;
import org.sc.models.User;
import org.sc.models.UserLogin;

import com.mysql.jdbc.ResultSet;

/**
 * @author Wesley
 * 
 **/

public class DAOOnline implements GenericDAO {

   private ConnectionMySql connection;
   private final String SERVER_NAME = "mysql07.soldadosdecristo2.hospedagemdesites.ws";
   private final String SERVER_USER = "soldadosdecris8";
   private final String SERVER_PW = "t1moteo23.";
   private final String SERVER_DB = "soldadosdecris8";

   public DAOOnline() {

   }

   @Override
   public boolean open() throws DAOException {
      connection = new ConnectionMySql(SERVER_USER, SERVER_NAME, SERVER_DB,
            SERVER_PW);
      return connection.isConnected();
   }

   @Override
   public boolean close() throws DAOException {

      try {
         return connection.close();
      } catch (Exception e) {
         throw new DAOException("Erro ao fechar conexão: " + e.getMessage());
      } finally {
         connection = connection.isConnected() ? connection : null;
      }
   }

   @Override
   public boolean persistDataByEntity(String newObj, String entity) {

      return false;
   }

   @Override
   public <T> List<T> findAllByEntityId(String entity) {
      String query = "SELECT * FROM " + entity + ";";
      try {
         ResultSet resultSet = connection.query(query);
      } catch (Exception e) {

      }
      return null;
   }

   @Override
   public List<Map<String, String>> findAllByColl(String entity,
         String[] colls, String condition) {

      List<Map<String, String>> retorno = new ArrayList<Map<String, String>>();
      String colunas = "";
      for (int i = 0; i < colls.length; i++) {
         colunas += colls[i] + (i < colls.length - 1 ? ", " : "");
      }
      String query = "SELECT " + colunas + " FROM " + entity + " " + condition
            + ";";
      try {
         ResultSet resultSet = connection.query(query);
         Map<String, String> mapResultMap;
         while (resultSet.next()) {
            mapResultMap = new HashMap<>();
            for (int i = 0; i < colls.length; i++) {
               mapResultMap.put(colls[i], resultSet.getString(colls[i]));
            }
            retorno.add(mapResultMap);
         }

      } catch (Exception e) {

      }

      return retorno;
   }

   @Override
   public <T> T findByEntityId(String entity, int id) {
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
   public User findUserLoginByField(String entity, String field,
         String fieldValue) throws DAOException {
      String queryString = "SELECT U.registry, U.name, U.warname, U.RG, U.battalion, U.patent, U.status, L.userName, L.password, U.email"
            + " FROM "
            + entity
            + " L, user U WHERE "
            + field
            + " = \""
            + fieldValue + "\" and L.userAdmin = U.registry";
      User user = null;
      try {
         ResultSet resultSet = connection.query(queryString);
         if (resultSet.first()) {
            user = new UserLogin(resultSet.getInt("registry"),
                  resultSet.getString("name"), resultSet.getString("warName"),
                  resultSet.getInt("RG"), resultSet.getInt("battalion"),
                  resultSet.getInt("patent"), resultSet.getString("status"),
                  resultSet.getString(""), "", resultSet.getString("email"));
         }
      } catch (Exception e) {
         throw new DAOException("Erro na consulta do banco de dados: "
               + e.getMessage());
      }

      return user;
   }

   @Override
   public ResultSet query(String query) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int getOperation(String operation, String atribute, String entite)
         throws DAOException {
      int retorno = 0;
      String queryFull = "SELECT " + operation + "(" + atribute
            + ") as countNumber FROM "
            + entite + ";";
      try {
         ResultSet resultSet = connection.query(queryFull);
         if (resultSet.first()) {
            retorno = resultSet.getInt("countNumber");
         }
         return retorno;
      } catch (Exception e) {
         throw new DAOException("Erro na consulta do banco de dados: "
               + e.getMessage());
      }

   }

   @Override
   public boolean queryToOtherCommands(String query) throws DAOException {
      try {
         connection.queryToUpdateDB(query);
         return true;
      } catch (SQLException e) {
         System.out.println(query);
         throw new DAOException("Erro na operação com o banco de dados: "
               + e.getMessage());
      }

   }
}
