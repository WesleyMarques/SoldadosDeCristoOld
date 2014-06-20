/**
 * this class is responsible to create a connection online with the database
 * the data base is a server:
 * 			name:
 * 			user:
 * 			password:
 */
package org.sc.data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sc.codes.User;
import org.sc.codes.UserLogin;

/**
 * @author Wesley
 * 
 */
public class DataOnline {

	private static QueryData connection;
	private static List<User> users;
	private static List<User> login;

	public DataOnline() {
	}

	public static List<User> loadUsersLogin() throws Exception {
		List<Object> listUsersLogin = readUserLogin();		
		login = new ArrayList<User>();
		// Downcast da lista de usu�rios do tipo Object para User
		if (listUsersLogin != null) {
			for (Object object : listUsersLogin) {
				login.add((User) object);
			}
		}
		return login;
	}

	public static boolean saveData() {
		return false;
	}

	private static List<Object> readUserLogin() throws Exception {
		List<Object> usersAux = new ArrayList<Object>();
                connection = new QueryData(new ConnectionMySql("root", "localhost","SoldadosDeCristo", "151194"));
		
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

}
