package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Movie;

public class MovieDao extends MarvelDao {

	public Set<Movie> findAll() throws SQLException {

		String query = "SELECT * FROM movie";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Movie> movies = new HashSet<>();

		while (resultSet.next()) {

			movies.add(resultSetToMovie(resultSet));

		}

		connect.close();
		return movies;

	}

	public Set<Movie> findMoviesByName(String term) throws SQLException {

		String query = "SELECT * FROM movie m WHERE name LIKE '?' ORDER BY m.name";

		// port 3306, no password
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, "%" + term + "%");

		ResultSet resultSet = statement.getGeneratedKeys();

		Set<Movie> movies = new HashSet<>();

		while (resultSet.next()) {

			movies.add(resultSetToMovie(resultSet));

		}

		connect.close();
		return movies;

	}

	public Movie findMovieById(int id) throws SQLException {

		String query = "SELECT * FROM movie m WHERE id =?";

		// port 3306, no password
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();
		Movie movie = null;
		
		while (resultSet.next()){
			movie = resultSetToMovie(resultSet);
		}
		
		
		connect.close();

		return movie;

	}

	public Set<Movie> findMovieData(String name) throws SQLException {
		Set<Movie> movieData = findMoviesByName(name);
		return movieData;
	}

	Movie resultSetToMovie(ResultSet resultSet) {

		try {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			long gross = resultSet.getLong("gross");
			long budget = resultSet.getLong("budget");
			byte[] picture = resultSet.getBytes("picture");
			String history = resultSet.getString("history");
			java.util.Date date = resultSet.getDate("date");

			Movie m = new Movie(id, name, gross, budget, picture, history, date);

			return m;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}

	public Movie createMovie(Movie newMovie) throws SQLException {

		String query = "INSERT INTO `movie`( `name`, `gross`, `budget`) VALUES (?,?,?)";
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, newMovie.getName());
		statement.setLong(2, newMovie.getGross());
		statement.setLong(3, newMovie.getBudget());
		statement.execute();

		ResultSet keys = statement.getGeneratedKeys();
		keys.next();
		int id = keys.getInt(1);
		newMovie.setId(id);
		connect.close();
		return newMovie;

	}

	public void putHeroInMovie(int heroId, int movieId) throws SQLException {
		String query = "INSERT INTO `movie_hero`(`id_movie`, `id_hero`) VALUES (?,?)";
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, movieId);
		statement.setInt(2, heroId);
		statement.execute();

		connect.close();

	}

}
