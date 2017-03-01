package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;

public class HeroDaoTest {

	HeroDao dao;
	Connection connect;

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
	}

	@Test
	public void testFindHeroesByName() throws Exception {

		assertTrue(dao.findHeroesByName("Spiderman").size() == 1);
		assertFalse(dao.findHeroesByName("Spiderman").size() == 3);

		Hero spiderMan = dao.findHeroesByName("Spiderman").iterator().next();

		assertTrue(dao.findHeroesByName("i").contains(spiderMan));
		assertFalse(dao.findHeroesByName("o").contains(spiderMan));

		boolean found = false;
		for (Hero h : dao.findHeroesByName("man")) {
			if (h.equals(spiderMan)) {
				found = true;
			}
		}
		assertTrue(found);

		boolean found1 = false;
		for (Hero h : dao.findHeroesByName("men")) {
			if (h.equals(spiderMan)) {
				found1 = true;
			}
		}
		assertFalse(found1);

	}

}
