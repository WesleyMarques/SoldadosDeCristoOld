package testing.sc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.sc.data.ConnectionMySql;
import org.sc.data.NetworkConnect;

public class TesteDataConnect {
	

        
        @Test
        public void deveConectarAoBDOnline(){
            ConnectionMySql conn = null;
            try {
                conn = new ConnectionMySql("soldadosdecris8", "186.202.152.69",
                        "soldadosdecris8", "t1moteo23.");
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                fail();
            }
            try {
                conn.getConn().close();
            } catch (SQLException ex) {
               fail();
            }
            assertTrue(conn.getConn().isClosed());
        }
}
