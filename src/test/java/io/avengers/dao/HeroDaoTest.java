package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mysql.jdbc.AssertionFailedException;

import io.avengers.domain.Hero;

public class HeroDaoTest {

	HeroDao dao;
	Connection connect;
	Hero test = new Hero(0,"tonton1");
	
	@Before
	public void setUp() throws Exception {
		dao = new HeroDao();
		connect = dao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertTrue(dao.findAll().size() > 5);
		assertNotNull(dao.findAll());
	}

	@Test
	public void testFindHeroesByName() throws SQLException {

		Hero spiderman = dao.findHeroesByName("Spider").iterator().next();
			
		assertNotNull(dao.findHeroesByName("Spider"));
	
		assertTrue(dao.findHeroesByName("Spider").size() == 1);
		assertFalse(dao.findHeroesByName("Spider").size() == 3);
		
		

		assertTrue(spiderman.getName().contains("man"));
				
		assertFalse(spiderman.getName().contains("o"));

		boolean found = false;
		for (Hero h : dao.findHeroesByName("man")) {
			if (h.equals(spiderman)) {
				found = true;
			}
		}
		assertTrue(found);

		boolean found1 = false;
		for (Hero h : dao.findHeroesByName("men")) {
			if (h.equals(spiderman)) {
				found1 = true;
			}
		}
		assertFalse(found1);

	}
	@Test
	public void testFindHeroesById() throws SQLException{
		assertTrue(dao.findHeroesById(1).getName().equals("Spiderman"));
		assertFalse(dao.findHeroesById(1).getName().equals("Hulk"));
	}
	//TODO
	@Ignore
	@Test
	public void testCreateModifyDeleteHero() throws SQLException {
		int testId=dao.createHero(test);
		System.out.println(testId);
		assertTrue(testId!=0);
		test= dao.findHeroesById(testId);
		System.out.println(test.getName());
		test.setIrl("tururu");
		dao.CreateHeroIrl(test);
		dao.putHeroInTeam(2, testId);
		dao.deleteHero(test);
	}
	
}
