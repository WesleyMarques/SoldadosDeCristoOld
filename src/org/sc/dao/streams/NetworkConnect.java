package org.sc.dao.streams;

import java.io.IOException;
import java.net.*;

public class NetworkConnect {

    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;

    private static boolean status;

    /**
     * Method that verify connection with the internet
     *
     * @return true it's Ok and false otherwise
     */
    public static boolean getTypeConn() {
        testConnection();
        return status;
    }

    private static void testConnection() {
        InetAddress endereco = null;
        try {
            // URL do destino escolhido
            URL url = new URL("http://186.202.152.69");
            
            // abre a conexãoo
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

            // tenta buscar conteúdo da URL
            // se não tiver conexão, essa linha irá falhar
            Object objData = urlConnect.getContent();
        } catch (UnknownHostException e) {
            status = OFFLINE;
            return;
        } catch (IOException e) {
            status = OFFLINE;
            return;
        }
        status = ONLINE;

    }
}
