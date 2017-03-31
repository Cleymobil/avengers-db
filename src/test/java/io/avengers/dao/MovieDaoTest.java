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

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.dao.MoviesHeroesDao;

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
	@Test
	public void testFindMovieById() throws SQLException{
		Movie movie = movieDao.findMovieById(2);
		System.out.println(movie);
		assertFalse(movie.getName().isEmpty());
		assertTrue(movie.getId()==2);
		
	}
	
	@Test
	public void testCreateMovieAndDeleteMovie() throws SQLException {
		
		Movie movie = new Movie("testName", 4651348, 8765131);
		movieDao.createMovie(movie);
		long budget = movieDao.findMoviesByName("testName").iterator().next().getBudget();
		assertTrue( budget == 8765131);
		int id = movie.getId();
		movieDao.deleteMovie(id);
		assertTrue(movieDao.findMovieById(id)==null);
		
	}
	
	@Test
	public void testCreateFullMovieAndDeleteMovie() throws SQLException {
		
		Movie movie = new Movie("testNameFull", 4651348, 8765131,"we are doing a test");
		movieDao.createFullMovie(movie);
		long budget = movieDao.findMoviesByName("testNameFull").iterator().next().getBudget();
		assertTrue( budget == 8765131);
		int id = movie.getId();
		movieDao.deleteMovie(id);
		assertTrue(movieDao.findMovieById(id)==null);
	}
	
	@Test
	public void testPutHeroInMovieAndDeleteIt() throws SQLException {
		
		Movie movie = new Movie("testNameFullHero", 4651348, 8765131);
		movieDao.createMovie(movie);
		int movieId = movie.getId();
		Hero hero = new Hero("TestHero","TestHeroIRL");
		HeroDao heroDao = new HeroDao();
		heroDao.createHero(hero);
		int heroId = hero.getId();
		movieDao.putHeroInMovie(heroId, movieId);
		MoviesHeroesDao moviesHeroesDao = new MoviesHeroesDao();
		assertTrue(moviesHeroesDao.findHeroesbyMovies("testNameFullHero").contains("TestHero"));
		movieDao.deleteHeroInMovie(movieId, heroId);
		assertFalse(moviesHeroesDao.findHeroesbyMovies("testNameFullHero").contains("TestHero"));
		movieDao.deleteMovie(movieId);
		heroDao.deleteHero(hero);
	}
	
	
}
