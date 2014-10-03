package org.sc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import org.sc.models.*;

/**
 * @author Wesley
 *
 */
public class DAOOffline implements GenericDAO{
	
	private File file;
    private final String PATH = "filesOff/";
    private final String ARQUIVO_NAO_ENCONTRADO = "Arquivo Não Encontrado!\nContact o Administrador pela área do FEEDBACK";
    private final String ERRO_NA_LEITURA_DO_ARQUIVO = "Erro na leitura do arquivo!\nContact o Administrador pela área do FEEDBACK";
    //Para realizar a leitura dos dados no arquivos
    private ObjectInputStream in = null;
    private FileInputStream fileIn = null;
    
    //Para realizar a escrita dos dados no arquivo
    private FileOutputStream out = null;
    private ObjectOutputStream outObj = null;
    
    public DAOOffline() {
	}

    
    @Override
	public boolean open() throws Exception {
		return false;
	}


	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean persistDataByEntity(Object newObj, String entity) {
		
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
	public <T> T removeByEntityId(String entidade, int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> boolean updateByEntityId(String entity, int id, Object newObject) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<Object> readData(File file) throws Exception{
        List<Object> dataObject = null;
        
        	try {
				in = new ObjectInputStream(new FileInputStream(file));
			} catch (StreamCorruptedException e) {
				throw new Exception("Erro no stream: "+ e.getMessage());
			} catch (FileNotFoundException e) {
				throw new Exception("Erro no arquivo: "+ e.getMessage());
			} catch (IOException e) {
				throw new Exception("Erro no Carregamento: "+ e.getMessage());
			}
        	if (in != null) {
				dataObject = (List<Object>) in.readObject();
				in.close();
        	}
        return dataObject;
    }
	
	public boolean saveData(File file, Object obj) throws Exception{
    	FileOutputStream out = null;
        ObjectOutputStream outObj = null;
        try {
            try { 
            	out = new FileOutputStream(file);
            	outObj = new ObjectOutputStream(out);
            } catch (FileNotFoundException e) {
            	System.err.println(e.getMessage());
                return false;
            }
            outObj.writeObject(obj);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar os dados");
        }finally{
        	out.close();
            outObj.close();
        }
        return true;
    }
	
	
  
	
}
