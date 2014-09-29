/**
 *
 */
package org.sc.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.sc.models.*;

/**
 * @author Wesley
 *
 */
public class DAOOffline implements GenericDAO{
	
	private File file;
    private final String PATH = "src/org/sc/archives/";
    private final String ARQUIVO_NAO_ENCONTRADO = "Arquivo Não Encontrado!\nContact o Administrador pela área do FEEDBACK";
    private final String ERRO_NA_LEITURA_DO_ARQUIVO = "Erro na leitura do arquivo!\nContact o Administrador pela área do FEEDBACK";
    
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
	public <T> T removeByEntityId(String entidade, int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> boolean updateByEntityId(String entity, int id, Object newObject) {
		// TODO Auto-generated method stub
		return false;
	}
  
	
}
