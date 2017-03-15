package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

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

		String query = "SELECT * FROM team  WHERE id=" + id + "";

		// port 3306, no password
		Connection connect = connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Team team = new Team();
		while (resultSet.next()) {

			team = resultSetToTeam(resultSet);

		}

		connect.close();
		return team;

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

}
