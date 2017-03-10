package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Sex;

public class HeroDao extends MarvelDao {

	public Set<Hero> findAll() throws SQLException {

		String query = "SELECT h.id AS hero_id, h.name AS name,h.sex sex, h.picture heroPicture, h.abilities heroHabilities, irl.name AS realName "
				+ "FROM heroes h " + "LEFT JOIN `irl` irl ON h.id = irl.hero_id " + "ORDER BY h.name ASC";

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

	public Set<Hero> findHeroesByName(String term) throws SQLException {

		String query = "SELECT * FROM heroes h WHERE name LIKE '%" + term + "%' ORDER BY h.name";

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
public Hero findHeroesById(int id) throws SQLException {
		
		String query = "SELECT * FROM heroes h WHERE h.id LIKE " + id + " ORDER BY h.name";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Hero heroe=null;

		while (resultSet.next()) {

			heroe= resultSetToHero(resultSet);

		}

		connect.close();
		return heroe;
	}
	Hero resultSetToHero(ResultSet resultSet) {

		try {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String realName = resultSet.getString("realName");
			String sSex = resultSet.getString("sex");
			Long likes = resultSet.getLong("likes");
			Long dislikes = resultSet.getLong("dislikes");
			byte[] picture = resultSet.getBytes("picture");
			String abilities = resultSet.getString("abilities");
			String history = resultSet.getString("history");

			Hero h = new Hero(id, name, Sex.O ,realName, likes, dislikes, picture, abilities, history);

			return h;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}
}
