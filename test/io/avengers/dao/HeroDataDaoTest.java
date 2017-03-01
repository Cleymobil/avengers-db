package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;

public class HeroDataDaoTest {
	
	HeroDataDao dao;
	Connection connect;


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
		assertTrue(dao.findHeroData("Wolverine").getTeam().equals("Xmen"));
		
	
	}

}
