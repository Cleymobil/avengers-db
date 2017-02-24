package io.avengers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Sex;

public class HeroDao {

	static Class c;

	public HeroDao() {
		if (c == null) {
			try {
				c = Class.forName("com.mysql.jdbc.Driver"); // define as static
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("MySql driver is not here: " + e.getMessage());

			}
		}
	}

	public Set<Hero> findAll() throws SQLException {

		String query = "SELECT * FROM heroes";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Hero> heroes = new HashSet<>();

		while (resultSet.next()) {

			heroes.add(resultSetToHero(resultSet));

		}

		connect.close();
		return heroes;

	}

	public Set<Hero> findHerosbyName(String term) throws SQLException {

		String query = "SELECT h.name FROM heroes h WHERE name LIKE %" + term + "% ORDER BY h.name";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Hero> heroes = new HashSet<>();

		while (resultSet.next()) {

			heroes.add(resultSetToHero(resultSet));

		}

		connect.close();
		return heroes;

	}

	Hero resultSetToHero(ResultSet resultSet) {

		try {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String sSex = resultSet.getString("sex");
			Long likes = resultSet.getLong("likes");
			Long dislikes = resultSet.getLong("dislikes");

			Hero h = new Hero(id, name, Sex.O, likes, dislikes);

			return h;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}

	Connection connectToMySql() {
		Connection connect;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvel", "root", "");
			return connect;
		} catch (SQLException e) {
			throw new IllegalStateException("Wrong credentials or url, or overloaded connection: " + e.getMessage());
		}

	}
}
