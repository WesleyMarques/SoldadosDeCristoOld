package org.sc.dao.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Wesley
 */
public class FTPSC {
	private final String SERVIDOR = "ftp.soldadosdecristo2.hospedagemdesites.ws";
	private final String USER = "soldadosdecristo2";
	private final String PASSWORD = "t1moteo23.";
	private final String BASE_PATH = "SoftwareFiles/";

	private FTPClient ftpCliente;

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

	public boolean uploadFile(String fileName, String pathFile)
			throws FileNotFoundException, IOException {
		FileInputStream fileToSend = new FileInputStream(pathFile);
		return ftpCliente.storeFile(BASE_PATH+fileName, fileToSend);
	}

	public void closeConnection() throws IOException {
		ftpCliente.logout();
		ftpCliente.disconnect();
	}

}
