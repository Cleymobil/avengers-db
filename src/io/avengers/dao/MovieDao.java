package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Movie;

public class MovieDao extends MarvelDao{



	public Set<Movie> findAll() throws SQLException {

		String query = "SELECT name FROM movie";

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

		String query = "SELECT * FROM movie m WHERE name LIKE '%" + term + "%' ORDER BY m.name";

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

	public Set<Movie> findMovieData(String name) throws SQLException{
		Set<Movie> movieData=findMoviesByName(name);
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
	
	
	
	
}
