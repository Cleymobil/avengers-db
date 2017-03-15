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
	public Movie findMovieById(int Id) {
				
		try {
			return new MovieDao().findMovieById(Id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	public Movie createMovie(Movie movie){
		MovieDao movieDao = new MovieDao();
	
		try {
			return movieDao.createMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	public void deleteMovie(int movieId){
		MovieDao movieDao = new MovieDao();
		try {
			movieDao.deleteMovie(movieId);
		} catch (Exception e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public void putHeroInMovie(int heroId, int movieId ){
		MovieDao movieDao = new MovieDao();
		try {
			movieDao.putHeroInMovie(heroId, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	
}
