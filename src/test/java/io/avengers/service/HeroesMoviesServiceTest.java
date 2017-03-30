package io.avengers.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.avengers.domain.Hero;

public class HeroesMoviesServiceTest {

	HeroesMoviesService heroesMoviesService;

	Hero test = new Hero("tonton1", "tuntun", 2);

	@Before
	public void setUp() throws Exception {
		heroesMoviesService = new HeroesMoviesService();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindMoviesByHeroesname() throws SQLException {

		assertTrue(heroesMoviesService.findMoviesByHeroesname("Spider").size() > 1);

	}

}
