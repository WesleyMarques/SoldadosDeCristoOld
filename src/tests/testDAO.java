package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sc.dao.DAOOffline;
import org.sc.dao.DAOOnline;
import org.sc.dao.GenericDAO;

public class testDAO{

	public GenericDAO dao;
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
	public void abreConexaoComBDOffline() throws IOException{
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
