package org.sc.dao;

import java.util.List;
import java.util.Map;

import org.sc.models.User;

/**
 * Serviços simples de um Data Access Object (DAO)
 **/
public interface GenericDAO {
	
	/**
	 * Conectar objetos necessário para realizar operação a base de dados.
	 * 
	 * @return {@code <code>true</code>} caso tenha sido bem sucedido e {@code <code>false</code>} c.c.
	 * @throws Exception
	 */
	boolean open() throws Exception;
	

	/**
	 * Remove todas conexões com a base de dados
	 * @return {@code <code>true</code>} caso tenha sido bem sucedido e {@code <code>false</code>} c.c.
	 * @throws Exception
	 */
	boolean close() throws Exception;
	
   /**
    * Persiste um objeto dado uma entidade específica
    * @param newObj Novo dado a ser persistido na base de dados
    * @param entity Entidade a qual o objeto pertence
    * @return
    */
    boolean persistDataByEntity(String newObj, String entity);
    
    /**
     * Listar todos os  dados contidos na base de dados que pertencem a entidade passada por parâmetro 
     * @param entity
     * @return
     */
    <T> List<T> findAllByEntityId(String entity);
    
    /**
     * Listar o objeto contidos na base de dados que pertencem a entidade passada por parâmetro e seu respectivo id
     * @param entity
     * @param id
     * @return
     */
    <T> T findByEntityId(String entity, int id);
    
    /**
     * Listar objectos de acordo com um atributo específico
     * @param entity
     * @param field
     * @param fieldValue
     * @return
     * @throws Exception 
     */
    User findUserLoginByField(String entity, String field, String fieldValue) throws Exception;

    /**
     * Deleta do banco de dados uma entidade referenciada pelo seu
     * {@code id}.
     **/
    <T> T removeByEntityId(String entidade, int id);
    
    /**
     * 
     * @param entity
     * @param id
     * @param newObject
     * @return
     */
    <T> boolean updateByEntityId(String entity, int id, Object newObject);
    
    /**
     * 
     * @param query
     * @return 
     */
    Map<String, String> query(String query);

}
