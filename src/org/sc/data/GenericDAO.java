package org.sc.data;

import java.util.List;

/**
 * Servi�os simples de um Data Access Object (DAO)
 **/
public interface GenericDAO {
	
	/**
	 * Abrir uma conex�o para realizar as opera��es com a base de dados
	 * @return true caso a conex�o tenha sido bem sucedida e false c.c.
	 * @throws Exception 
	 */
	boolean open() throws Exception;
	

	/**
	 * Fechar conex�o do tipo de base de dados
	 * @return
	 */
	boolean close();
	
    /**
     * Persiste uma entidade no Banco de Dados.
     **/
    boolean persistDataByEntity(Object newObj, String entity);
    
    /**
     * Procura uma certa entidade pelo seu {@code id}.
     **/
    <T> List<T> findAllByEntityId(String entity);
    
    /**
     * Procura uma certa entidade pelo seu {@code id}.
     **/
    <T> T findByEntityId(String entity, int id);

    /**
     * Deleta do banco de dados uma entidade referenciada pelo seu
     * {@code id}.
     **/
    <T> T removeByEntityId(String entidade, int id);
    
    <T> boolean updateByEntityId(String entity, int id, Object newObject);

}
