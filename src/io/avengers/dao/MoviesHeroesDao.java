package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class MoviesHeroesDao extends MarvelDao {

	public Set<String> findHeroesbyMovies(String name) throws SQLException {
		String query = "SELECT h.name FROM movie_hero mh JOIN heroes h ON h.id=mh.id_hero JOIN movie m ON mh.id_movie=m.id WHERE m.name LIKE '%"
				+ name + "%' ORDER BY h.name;";
		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<String> heroesMovies = new HashSet<>();

		while (resultSet.next()) {

			heroesMovies.add(resultSetToMoviesHeroes(resultSet));
		}

		connect.close();
		return heroesMovies;
	}

	private String resultSetToMoviesHeroes(ResultSet resultSet) {

		try {

			String heroesName = resultSet.getString("name");
			return heroesName;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}
}
