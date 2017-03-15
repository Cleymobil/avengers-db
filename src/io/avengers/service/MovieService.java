package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.MovieDao;
import io.avengers.domain.Movie;

public class MovieService {

	IllegalStateException stateException = new IllegalStateException(
			"There is an error in the database please try again later");

	public Set<Movie> findAll() {

		try {
			return new MovieDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Set<Movie> findMoviesByName(String term) {
		if (term == null) {
			System.out.println("Potential bug or illegal request");
			return this.findAll();
		}
		if (term.isEmpty()) {
			return this.findAll();
		}

		try {
			return new MovieDao().findMoviesByName(term);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public Movie createMovie(Movie movie){
		MovieDao mvd = new MovieDao();
	
		try {
			return mvd.createMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

}
