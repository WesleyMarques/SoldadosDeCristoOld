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
public class DataOnline implements DAO {

    private static QueryData connection;
    private final static String SERVER_NAME = "186.202.152.69";
    private final static String SERVER_USER = "soldadosdecris8";
    private final static String SERVER_PW = "t1moteo23.";
    private final static String SERVER_DB = "soldadosdecris8";

    public DataOnline() {
    }

    @Override
    public List<User> loadUsersLogin() throws Exception {
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

    private List<Object> readUserLogin() throws Exception {
        List<Object> usersAux = new ArrayList<Object>();
        connection = new QueryData(new ConnectionMySql(SERVER_USER, SERVER_NAME, SERVER_DB, SERVER_PW));

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
