package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.MovieDao;
import io.avengers.dao.TeamDao;
import io.avengers.domain.Hero;
import io.avengers.domain.Movie;
import io.avengers.domain.Team;

public class TeamService {

	IllegalStateException stateException = new IllegalStateException(
			"There is an error in the database please try again later");

	public Set<Team> findAll() {

		try {
			return new TeamDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Team findTeamById(int id) {

		try {
			return new TeamDao().findTeamById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	
	public Set<Hero> findTeamHeroes(int id) {

		try {
			return new TeamDao().findTeamHeroes(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	
	

	public void createTeam(String name, String history) {

		try {
			new TeamDao().createTeam(name, history);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}

	}

	public void deleteTeam(int id) {
		try {
			new TeamDao().deleteTeam(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}		
	}
	
	
	

}
