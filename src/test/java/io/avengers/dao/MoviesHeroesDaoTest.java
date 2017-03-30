package io.avengers.dao;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

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

	@Test
	public void testFindHeroesbyMovies() throws Exception {
		Set<String> heroesMovies = moviesHeroesDao.findHeroesbyMovies("Avengers");
		System.out.println(heroesMovies);
		assertTrue(heroesMovies.size() > 3);
		assertTrue(heroesMovies.contains("Hulk"));
	}

}
