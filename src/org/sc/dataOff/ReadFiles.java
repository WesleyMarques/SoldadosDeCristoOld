package org.sc.dataOff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;

import org.sc.dao.DAOException;

/**
 * @author Wesley
 * 
 */
public class ReadFiles {

   private final String PATH = "files/";
   private final String ARQUIVO_NAO_ENCONTRADO = "Arquivo Não Encontrado!\nContact o Administrador pela área do FEEDBACK";
   private final String ERRO_NA_LEITURA_DO_ARQUIVO = "Erro na leitura do arquivo!\nContact o Administrador pela área do FEEDBACK";

   // Para realizar a leitura dos dados no arquivos
   private ObjectInputStream in = null;
   private FileInputStream fileIn = null;

   // Para realizar a escrita dos dados no arquivo
   private FileOutputStream out = null;
   private ObjectOutputStream outObj = null;

   public ReadFiles() {
   }

   public List<Object> readData(String fileName) throws IOException,
         ClassNotFoundException {
      List<Object> dataObject = null;
      try {
         in = new ObjectInputStream(new FileInputStream(PATH + fileName));
         if (in != null) {
            dataObject = ((List<Object>) in.readObject());
            System.err.println("ok: " + dataObject.size());
            in.close();
         }
      } catch (StreamCorruptedException e) {
         throw new StreamCorruptedException("Erro no stream: " + e.getMessage());
      } catch (FileNotFoundException e) {
         throw new FileNotFoundException("Erro no arquivo: " + e.getMessage());
      } catch (IOException e) {
         throw new IOException("Erro no Carregamento: " + e.getMessage());
      } catch (ClassNotFoundException e) {
         throw new ClassNotFoundException("Classe não encontrada: "
               + e.getMessage());
      }
      return dataObject;
   }

   public boolean saveData(String file, List<Object> obj) throws Exception {
      FileOutputStream out = null;
      ObjectOutputStream outObj = null;

      try {
         try {
            out = new FileOutputStream(PATH + file);
            outObj = new ObjectOutputStream(out);
         } catch (FileNotFoundException e) {
            throw e;
         }
         System.err.println(obj.size());
         outObj.writeObject(obj);

      } catch (Exception e) {

         throw new Exception("Erro ao salvar os dados");
      } finally {
         out.close();
         outObj.close();
      }
      return true;
   }

   public boolean loadFile(String fileName, List<Object> obj)
         throws DAOException {
      File file = new File(PATH + fileName);
      if (!file.exists()) {
         try {
            return file.createNewFile()
                  && saveData(fileName, obj);
         } catch (Exception e) {
            throw new DAOException("Erro ao salvar ou criar o arquivo: "
                  + e.getMessage());
         }
      }
      return true;
   }
}
