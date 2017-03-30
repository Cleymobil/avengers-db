package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HeroesMoviesDaoTest {
	HeroesMoviesDao heroesMoviesDao;
	Connection connect;

	@Before
	public void setUp() throws Exception {
		heroesMoviesDao = new HeroesMoviesDao();
		connect = heroesMoviesDao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}
	
	@Test
	public void testFindMoviesByHeroesname() throws SQLException {
		
		assertTrue(heroesMoviesDao.findMoviesByHeroesname("Spider").size() > 1);
		
	}

}
