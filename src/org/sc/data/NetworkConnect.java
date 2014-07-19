package org.sc.data;

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
            URL url = new URL("http://www.google.com");

            // abre a conex�o
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

            // tenta buscar conte�do da URL
            // se n�o tiver conex�o, essa linha ir� falhar
            Object objData = urlConnect.getContent();
        } catch (UnknownHostException e) {
            // e.printStackTrace();
            status = OFFLINE;
            return;
        } catch (IOException e) {
            status = OFFLINE;
            return;
        }
        status = ONLINE;

    }
}
