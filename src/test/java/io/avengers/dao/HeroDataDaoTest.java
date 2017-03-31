package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.reset.ResetApplication;

public class HeroDataDaoTest {
	
	HeroDataDao dao;
	Connection connect;
	
	@BeforeClass
	public static void deleteDataBase() throws Exception {
		ResetApplication.main(new String[]{});
	}


	@Before
	public void setUp() throws Exception {
		dao = new HeroDataDao();
		connect = dao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}
	
	@Test
	public void testFindHeroData() throws SQLException {
		assertTrue(dao.findHeroData("Hulk").getIrl().equals("Bruce Banner"));
		assertTrue(dao.findHeroData("Wolverine").getTeam().equals("X-men"));
		
	
	}

}
