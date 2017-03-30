package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.avengers.domain.Movie;

public class MovieDaoTest {

	MovieDao movieDao;
	Connection connect;

	@Before
	public void setUp() throws Exception {
		movieDao = new MovieDao();
		connect = movieDao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertTrue(movieDao.findAll().size() > 3);
	}
	
	@Test
	public void testFindMoviesByName() throws Exception {
		Set<Movie> movies = movieDao.findMoviesByName("enger");
		System.out.println(movies);
		assertTrue(movies.size() == 1);
		assertFalse(movies.size() == 3);

		Movie avengers = movieDao.findMoviesByName("Avengers").iterator().next();
		assertTrue(avengers.getName().equals("Avengers"));

		
	}

}
