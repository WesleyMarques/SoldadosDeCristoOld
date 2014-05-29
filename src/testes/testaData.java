package testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.sc.codes.User;
import org.sc.data.DataOffline;

public class testaData {
	
	@Test
	public void deveCarregarArquivo(){
		List<User> listaUsers = DataOffline.loadUsersLogin();
		assertFalse(listaUsers.isEmpty());
	}

}
