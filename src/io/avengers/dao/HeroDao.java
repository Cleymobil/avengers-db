package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Sex;

public class HeroDao extends MarvelDao {

	public Set<Hero> findAll() throws SQLException {

		String query = "SELECT h.id, h.name AS name,h.sex sex, h.picture ,h.likes, h.dislikes, h.abilities, h.history, irl.name AS realName FROM heroes h LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "ORDER BY h.name ASC";

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

		String query = "SELECT h.id, h.name AS name,h.sex sex, h.picture ,h.likes, h.dislikes, h.abilities, h.history, irl.name AS realName FROM heroes h LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "WHERE h.name LIKE '%" + term + "%' ORDER BY h.name";

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

		String query = "SELECT h.id, h.name AS name,h.sex sex, h.picture ,h.likes, h.dislikes, h.abilities, h.history, irl.name AS realName FROM heroes h LEFT JOIN `irl` irl ON h.id = irl.hero_id "
				+ "WHERE h.id LIKE " + id + " ORDER BY h.name";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Hero heroe = null;

		while (resultSet.next()) {

			heroe = resultSetToHero(resultSet);
		}
		connect.close();
		return heroe;
	}

	public int createHero(Hero hero) throws SQLException {

		String query = "INSERT INTO heroes (name, sex, likes, dislikes, picture, abilities, history) VALUES (?,?,?,?,null,?,?);";

		Connection connect = connectToMySql();
		PreparedStatement statement = connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setString(1, hero.getName());
		statement.setString(2, hero.getSex().toString());
		statement.setLong(3, hero.getLikes());
		statement.setLong(4, hero.getDislikes());
		statement.setString(5, hero.getAbilities());
		statement.setString(6, hero.getHistory());
		statement.execute();

		ResultSet rs = statement.getGeneratedKeys();
		int heroId = -1;
		if (rs.next()) {
			heroId = rs.getInt(1);
		}
		System.out.println("id " + heroId);

		String query2 = "INSERT INTO irl (hero_id, name) VALUES (?,?);";
		PreparedStatement statement2 = connect.prepareStatement(query2);
		statement2.setInt(1, heroId);
		statement2.setString(2, hero.getIrl());
		statement2.execute();
		connect.close();
		return heroId;
	}

	public void putHeroInTeam(int teamId, int heroId) throws SQLException {
		Connection connect = connectToMySql();
		String query = "INSERT INTO team_hero (team_id, hero_id) VALUES (?,?);";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, teamId);
		statement.setInt(2, heroId);
		statement.execute();

		connect.close();

	}

	public void deleteHero(Hero hero) throws SQLException {
		Connection connect = connectToMySql();
		String query = "DELETE FROM `team_hero` WHERE `hero_id` LIKE " + hero.getId() + ";";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.execute();
		String query2 = "DELETE FROM `irl` WHERE `hero_id` LIKE " + hero.getId() + ";";
		PreparedStatement statement2 = connect.prepareStatement(query2);
		statement2.execute();
		String query3 = "DELETE FROM `heroes` WHERE id LIKE " + hero.getId() + ";";
		PreparedStatement statement3 = connect.prepareStatement(query3);
		statement3.execute();

		connect.close();
	}
	public void removeTeamFromHero(Hero hero) throws SQLException {
		Connection connect = connectToMySql();
		String query = "DELETE FROM `team_hero` WHERE `hero_id` LIKE " + hero.getId() + ";";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.execute();
		connect.close();
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

			Hero h = new Hero(id, name, Sex.O, realName, likes, dislikes, picture, abilities, history);

			return h;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}
}
