package org.sc.dao.streams;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class NetworkConnect{

    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;

    /**
     * Method that verify connection with the internet
     *
     * @return true it's Ok and false otherwise
     */
    public static boolean getTypeConn() {
        
        return testConnection();
    }

    private static boolean testConnection() {
        InetAddress endereco = null;
        boolean status = ONLINE;
        try {
            // URL do destino escolhido
            URL url = new URL("http://google.com");
            
            // abre a conexãoo
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

            // tenta buscar conteúdo da URL
            // se não tiver conexão, essa linha irá falhar
            Object objData = urlConnect.getContent();
        } catch (UnknownHostException e) {
            status = OFFLINE;
        } catch (IOException e) {
            status = OFFLINE;
        }
        return status;

    }
}
