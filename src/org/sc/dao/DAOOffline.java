package org.sc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
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
   private File file;
   private final String PATH = "files/";
   private final String ARQUIVO_NAO_ENCONTRADO = "Arquivo Não Encontrado!\nContact o Administrador pela área do FEEDBACK";
   private final String ERRO_NA_LEITURA_DO_ARQUIVO = "Erro na leitura do arquivo!\nContact o Administrador pela área do FEEDBACK";

   // Para realizar a leitura dos dados no arquivos
   private ObjectInputStream in = null;
   private FileInputStream fileIn = null;

   // Para realizar a escrita dos dados no arquivo
   private FileOutputStream out = null;
   private ObjectOutputStream outObj = null;

   private List<UserLogin> userLogin;

   public DAOOffline() {
   }

   private List<User> readData() throws DAOException {
      List<User> dataObject = null;

      try {
         in = new ObjectInputStream(new FileInputStream(file));
         if (in != null) {
            dataObject = (List<User>) in.readObject();
            in.close();
         }
      } catch (StreamCorruptedException e) {
         throw new DAOException("Erro no stream: " + e.getMessage());
      } catch (FileNotFoundException e) {
         throw new DAOException("Erro no arquivo: " + e.getMessage());
      } catch (IOException e) {
         throw new DAOException("Erro no Carregamento: " + e.getMessage());
      } catch (ClassNotFoundException e) {
         throw new DAOException("Classe não encontrada: " + e.getMessage());
      }

      return dataObject;
   }

   public boolean saveData(File file, List<User> obj) throws Exception {
      FileOutputStream out = null;
      ObjectOutputStream outObj = null;
      try {
         try {
            out = new FileOutputStream(file);
            outObj = new ObjectOutputStream(out);
         } catch (FileNotFoundException e) {
            throw e;
         }
         outObj.writeObject(obj);
      } catch (Exception e) {
         throw new Exception("Erro ao salvar os dados");
      } finally {
         out.close();
         outObj.close();
      }
      return true;
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
      try{
         DataOffController.getUsers(LOGIN_USER_DAT_FILE);         
      }catch(){
         
      }
      List<User> dataObject = readData();
      try {
         for (User userList : dataObject) {
            if (((UserLogin) userList).equals(fieldValue)) {
               return userList;
            }
         }

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
