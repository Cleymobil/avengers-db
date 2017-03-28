package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;



public class HeroesMoviesDao extends MarvelDao {

	public Set<String> findMoviesByHeroesname(String term) throws SQLException {

		String query = "SELECT m.name FROM movie_hero mh JOIN heroes h ON mh.id_hero=h.id JOIN movie m ON m.id=mh.id_movie WHERE h.name LIKE '?' ORDER BY m.date; ";

		// port 3306, no password
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, "%" + term + "%");
		ResultSet resultSet = statement.getGeneratedKeys();

		Set<String> moviesHeroes = new HashSet<>();

		while (resultSet.next()) {

			moviesHeroes.add(resultSetToHeroesMovies(resultSet));
		}

		connect.close();
		return moviesHeroes;

	}
	private String resultSetToHeroesMovies(ResultSet resultSet) {

		try {
			
			String moviesName = resultSet.getString("name");
			return moviesName;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}
}
