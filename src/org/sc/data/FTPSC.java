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
     private final String SERVIDOR = "";
    private final String USER = "";
     private final String PASSWORD = "";
    
    private FTPClient ftpCliente;
    private String basePath;

    public FTPSC(String path) throws IOException {
        ftpCliente = new FTPClient();
        connect();
        
    }
    
    
    public FTPClient getFtpCliente() {
        return ftpCliente;
    }

    private void connect() throws IOException {
        ftpCliente.connect(SERVIDOR);
        ftpCliente.login(USER, PASSWORD);
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

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    
    
}
