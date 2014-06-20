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

	private static ConnectionMySql connection;
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
                connection = new ConnectionMySql("root", "localhost",
				"SoldadosDeCristo", "151194");
		Statement s = connection.getConn().createStatement();
		ResultSet r = null;

		r = s.executeQuery("Select U.registry, U.name, U.warName, U.RG, U.battalion, U.patent, U.status,"
				+ "U.email, A.userName, A.password  from Users U, Admin A, Patents P WHERE U.registry = A.userName;"); 
		while (r.next()) {
			usersAux.add(new UserLogin(r.getInt("registry"), r.getString("name"), r.getString("warName"), r.getInt("RG"), 
					r.getInt("battalion"), r.getInt("patent"), r.getString("status"), r.getString("userName"), 
					r.getString("password"), r.getString("email")));
		}

		r.close();
		s.close();

		return usersAux;
	}

}
