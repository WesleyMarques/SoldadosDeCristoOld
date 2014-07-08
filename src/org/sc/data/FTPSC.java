/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sc.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Wesley
 */
public class FTPSC {
    
    private FTPClient ftpCliente;
    private String servidor,
            user,
            password,
            basePath;

    public FTPSC(String serv, String user, String pw, String path) throws IOException {
        ftpCliente = new FTPClient();
        connect();
        
    }
    
    
    public FTPClient getFtpCliente() {
        return ftpCliente;
    }

    private void connect() throws IOException {
        ftpCliente.connect(servidor);
        ftpCliente.login(user, password);
    }
    
    public boolean uploadFile(String pathFile) throws FileNotFoundException, IOException{
        FileInputStream fileToSend = new FileInputStream(pathFile);
        if (ftpCliente.storeFile("novo nome", fileToSend)) {
            return true;
        }

        return false;
    }
    
    public void closeConnection() throws IOException{
        ftpCliente.logout();
        ftpCliente.disconnect();
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    
    
}
