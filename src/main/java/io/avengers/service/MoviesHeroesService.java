package io.avengers.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import io.avengers.dao.MoviesHeroesDao;

public class MoviesHeroesService {

	IllegalStateException stateException = new IllegalStateException(
			"There is an error in the database please try again later");

	public Set<String> findHeroesbyMovies(String name) throws SQLException {
		if (name == null) {
			System.out.println("This Movie isn't in the database");
			Set<String> emptySet = new HashSet<>();
			return emptySet;
		}
		if (name.isEmpty()) {
			System.out.println("This isn't a movie");
			return new HashSet<>();
		}
		try {
			return new MoviesHeroesDao().findHeroesbyMovies(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
}
