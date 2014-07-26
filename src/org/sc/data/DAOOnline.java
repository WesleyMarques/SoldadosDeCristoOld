/**
 * this class is responsible to create a connection online with the database the
 * data base is a server: name:186.202.152.69
 * user:soldadosdecris8@186.202.28.226 password:t1moteo23.
 */
package org.sc.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.sc.codes.User;
import org.sc.codes.UserLogin;

/**
 * @author Wesley
 *
 */
public class DAOOnline implements DAO {

    private ConnectionMySql connection;
    private final String SERVER_NAME = "186.202.152.69";
    private final String SERVER_USER = "soldadosdecris8";
    private final String SERVER_PW = "t1moteo23.";
    private final String SERVER_DB = "soldadosdecris8";

    public DAOOnline() {
    	
    }
    
    public boolean open() throws Exception{
    	connection = new ConnectionMySql(SERVER_USER, SERVER_NAME, SERVER_DB, SERVER_PW);
		return connection.isConnected();    	    	    	
    }

    @Override
    public List<User> loadUsers() throws Exception {
        List<Object> listUsersLogin = readUserLogin();
        ArrayList<User> login = new ArrayList<User>();
        // Downcast da lista de usuários do tipo Object para User
        if (listUsersLogin != null) {
            for (Object object : listUsersLogin) {
                login.add((User) object);
            }
        }
        return login;
    }

    private List<Object> readUserLogin() throws Exception {
        List<Object> usersAux = new ArrayList<Object>();
        

        ResultSet resultSet = connection.queryD("Select U.registry, U.name, U.warName, U.RG, U.battalion, "
                + "U.patent, U.status,U.email, A.userName, A.password  from Users U, Admin A, "
                + "Patents P WHERE U.registry = A.userName;");
        while (resultSet.next()) {
            usersAux.add(new UserLogin(resultSet.getInt("registry"), resultSet.getString("name"), resultSet.getString("warName"),
                    resultSet.getInt("RG"), resultSet.getInt("battalion"), resultSet.getInt("patent"), resultSet.getString("status"),
                    resultSet.getString("userName"), resultSet.getString("password"), resultSet.getString("email")));
        }

        resultSet.close();
        return usersAux;
    }

    @Override
    public List<Object> readData(String file) throws Exception {
        return null;
    }

    @Override
    public boolean saveData(String file) throws Exception {
        return false;
    }

}
