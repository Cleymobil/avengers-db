package io.avengers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class TeamDao  extends MarvelDao{

	
	
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
	
	public Set<Team> findTeamById(int id) throws SQLException {

		String query = "SELECT * FROM team  WHERE id="+id+"";

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

	private Team resultSetToTeam(ResultSet resultSet) {
		
		
		try {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			byte[] picture=resultSet.getBytes("picture");
			String history=	resultSet.getString("history");

			Team t = new Team(id, name,picture, history);

			return t;

		} catch (Exception e) {
			throw new IllegalStateException("Database has been compromised: " + e.getMessage());
		}
		
	}
}
