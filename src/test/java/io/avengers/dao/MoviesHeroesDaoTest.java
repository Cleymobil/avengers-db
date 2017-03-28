package io.avengers.dao;

import static org.junit.Assert.*;
import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MoviesHeroesDaoTest {
	MoviesHeroesDao moviesHeroesDao;
	Connection connect;

	@Before
	public void setUp() throws Exception {
		moviesHeroesDao = new MoviesHeroesDao();
		connect = moviesHeroesDao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}
	@Ignore 
	@Test
	public void testFindHeroesbyMovies() throws Exception {
		assertTrue(moviesHeroesDao.findHeroesbyMovies("Avengers").size() > 3);
		assertTrue(moviesHeroesDao.findHeroesbyMovies("Avengers").contains("Hulk"));
	}

}
