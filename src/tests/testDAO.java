package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sc.data.DAO;
import org.sc.data.DAOOffline;
import org.sc.data.DAOOnline;

public class testDAO{

	public DAO dao;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void abreConexaoComBDOnline() {
		dao = new DAOOnline();
		boolean connStatus;
		try {
			connStatus = dao.open();
			assertTrue(connStatus);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void abreConexaoComBDOffline(){
		dao = new DAOOffline();
		boolean connStatus;
		try {
			connStatus = dao.open();
			assertTrue(connStatus);
		} catch (Exception e) {
			fail();
		}
	}

}
