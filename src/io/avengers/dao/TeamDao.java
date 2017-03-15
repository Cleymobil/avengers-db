package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class TeamDao extends MarvelDao {

	public Set<Team> findAll() throws SQLException {

		String query = "SELECT * FROM team";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Set<Team> teams = new HashSet<>();

		while (resultSet.next()) {

			teams.add(resultSetToTeam(resultSet));

		}

		connect.close();
		return teams;

	}

	public Team findTeamById(int id) throws SQLException {

		String query = "SELECT * FROM team  WHERE id=?";

		// port 3306, no password
		Connection connect = connectToMySql();
		PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		Team team = new Team();
		while (resultSet.next()) {

			team = resultSetToTeam(resultSet);

		}

		connect.close();
		return team;

	}

	public Set<Hero> findTeamHeroes(int id) throws SQLException {

		String query = "SELECT h.id, h.name AS name,h.sex sex, h.picture ,h.likes, h.dislikes, h.abilities, h.history, irl.name AS realName FROM heroes h LEFT JOIN `irl` irl ON h.id = irl.hero_id LEFT JOIN team_hero th ON h.id=th.hero_id  LEFT JOIN team t ON t.id=th.team_id WHERE th.team_id =?";

		// port 3306, no password
		Connection connect = connectToMySql();
		PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		Set<Hero> heroes = new HashSet<>();

		while (resultSet.next()) {

			heroes.add(new HeroDao().resultSetToHero(resultSet));

		}

		connect.close();
		return heroes;

	}

	private Team resultSetToTeam(ResultSet resultSet) {

		try {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			byte[] picture = resultSet.getBytes("picture");
			String history = resultSet.getString("history");

			Team t = new Team(id, name, picture, history);

			return t;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}

	}

	public void createTeam(String name, String history) throws SQLException {

		String query = "INSERT INTO `team`(`name`, `picture`, `history`) VALUES (?,null,?)";

		// port 3306, no password
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, name);
		statement.setString(2, history);
		statement.execute();

		ResultSet rs = statement.getGeneratedKeys();
		int id = -1;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		System.out.println("id " + id);
		connect.close();

	}

	

	public void deleteTeam(int id) throws SQLException {

		
		String query = "DELETE FROM `team_hero` WHERE team_id=?";

		// port 3306, no password
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, id);
		statement.execute();

		
		
		
		String query2 = "DELETE FROM `team` WHERE id=?";
		
		PreparedStatement statement2 = connect.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
		statement2.setInt(1, id);
		statement2.execute();
		
		connect.close();

	}

}
