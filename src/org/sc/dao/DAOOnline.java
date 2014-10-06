/**
 * this class is responsible to create a connection online with the database the
 * data base is a server: name: 186.202.152.69
 * user:soldadosdecris8@186.202.28.226 password:t1moteo23.
 */
package org.sc.dao;

import java.sql.SQLException;
import java.util.List;

import org.sc.dao.mysql.ConnectionMySql;

import com.mysql.jdbc.ResultSet;

/**
 * @author Wesley
 * 
 **/

public class DAOOnline implements GenericDAO {

    private ConnectionMySql connection;
    private final String SERVER_NAME = "186.202.152.69";
    private final String SERVER_USER = "soldadosdecris8";
    private final String SERVER_PW = "t1moteo23.";
    private final String SERVER_DB = "soldadosdecris8";

    public DAOOnline() {
    	
    }
    
    @Override
    public boolean open() throws Exception{
    	connection = new ConnectionMySql(SERVER_USER, SERVER_NAME, SERVER_DB, SERVER_PW);
		return connection.isConnected();    	    	    	
    }

	@Override
	public boolean close() {
		connection.close();
		boolean connStatus = connection.isConnected();
		connection = null;
		return connStatus;
	}

	@Override
	public boolean persistDataByEntity(Object newObj, String entity) {
		
		return false;
	}

	@Override
	public <T> List<T> findAllByEntityId(String entity) {
		
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

	@Override
	public <T> T findByField(String entity, String field, String fieldValue) throws SQLException {
		String queryString = "SELECT * FROM "+entity+" WHERE "+field+"="+fieldValue;
		ResultSet resultSet = connection.query(queryString);
		//fazer um for para pegar o resultado para retornar  para a classe chamada
		return null;
	}
    
    
    
}
