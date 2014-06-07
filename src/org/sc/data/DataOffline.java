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
    private static final String PATH = "src/org/sc/archives/";
    private static final String ARQUIVO__NÃO__ENCONTRADO = "Arquivo Não Encontrado!\nContact o Administrador pela área do FEEDBACK";
    private static final String ERRO_NA_LEITURA_DO_ARQUIVO = "Erro na leitura do arquivo!\nContact o Administrador pela área do FEEDBACK";


    

    /**
     * Load users from file
     *
     * @return Returns a users list.
     *
     *
     *
     */
    public static List<User> loadUsersLogin() throws Exception {
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
    private static List<Object> readData(String file) throws Exception{
        ObjectInputStream in = null;
        List<Object> dataObject = null;
        try {
            try {
                in = new ObjectInputStream(new FileInputStream(PATH+file));
                dataObject = (ArrayList<Object>) in.readObject();
            } catch (FileNotFoundException e) {
                throw new Exception(ARQUIVO__NÃO__ENCONTRADO);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            in.close();
        } catch (IOException ex) {
            throw new Exception(ERRO_NA_LEITURA_DO_ARQUIVO);
            
        }
        return dataObject;
    }

    /**
     * Save data in archive
     * @param file
     * @return
     */
    public static boolean saveData(String file) throws Exception{
        ObjectOutputStream out = null;
        try {
            try {
                out = new ObjectOutputStream(new FileOutputStream(PATH+file));
            } catch (FileNotFoundException e) {
                throw new Exception(ARQUIVO__NÃO__ENCONTRADO);
            }
            if (file.equals(PATH+"NewUsers.dat")) {
                out.writeObject(users);
            } else {
                out.writeObject(login);
            }
            out.close();
        } catch (IOException e) {
            throw new Exception(ERRO_NA_LEITURA_DO_ARQUIVO);
        }
        return true;
    }
}
