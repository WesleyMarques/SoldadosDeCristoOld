/**
 *
 */
package org.sc.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.sc.codes.*;

/**
 * @author Wesley
 *
 */
public class DataOffline {

    private static List<User> users;
    private static List<User> login;
    
    

    /**
     * Load users from file
     *
     * @return Returns a users list.
     *
     *
     *
     */
    public static List<User> loadUsersLogin() {
        List<Object> listUsers;
        listUsers = readData("UserLoginOff.dat");
        login = new ArrayList<User>();
        // Downcast da lista de usuários do tipo Object para User
        if (listUsers != null) {
            for (Object object : listUsers) {
                login.add((User) object);
            }
        }
        saveData("UserLoginOff.dat");
        return login;
    }

    /**
     * Read a file.
     *
     * @param file Name of the file.
     * @return An object list, with the information about the file.
     */
    private static List<Object> readData(String file) {
        ObjectInputStream in = null;
        List<Object> dataObject = null;
        try {
            try {
                in = new ObjectInputStream(new FileInputStream(file));
                dataObject = (ArrayList<Object>) in.readObject();
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            in.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return dataObject;
    }

    /**
     * Save data in archive
     *
     * @param file
     * @return
     */
    public static boolean saveData(String file) {
        ObjectOutputStream out = null;
        try {
            try {
                out = new ObjectOutputStream(new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                return false;
            }
            if (file.equals("NewUsers.dat")) {
                out.writeObject(users);
            } else {
                out.writeObject(login);
            }
            out.close();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        return true;
    }
}
