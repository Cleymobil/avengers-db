package io.avengers.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import io.avengers.dao.HeroesMoviesDao;


public class HeroesMoviesService {

	IllegalStateException stateException = new IllegalStateException(
			"There is an error in the database please try again later");

	public Set<String> findMoviesByHeroesname(String term) throws SQLException {
		if (term == null) {
			System.out.println("This Hero isn't in the database");
			Set<String> emptySet = new HashSet<>();
			return emptySet;
		}
		if (term.isEmpty()) {
			System.out.println("This isn't a hero");
			return new HashSet<>();
		}

		try {
			return new HeroesMoviesDao().findMoviesByHeroesname(term);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}

	}
}
