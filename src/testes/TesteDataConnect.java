package testes;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.sc.data.ConnectionMySql;
import org.sc.data.DataBaseConnect;

public class TesteDataConnect {
	
	
	@Test
	public void isOnline() throws SQLException{
		
		
		ConnectionMySql connection = new ConnectionMySql("root", "localhost",
				"SoldadosDeCristo", "151194");
		connection.getConn().close();
		System.out.println(connection.getConn().isClosed());
		
	}

}
