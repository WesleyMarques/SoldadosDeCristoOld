/**
 * this class is responsible to create a connection online with the database the
 * data base is a server: name:186.202.152.69
 * user:soldadosdecris8@186.202.28.226 password:t1moteo23.
 */
package org.sc.data;

import java.util.List;

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
