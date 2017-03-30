package io.avengers.ui;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.TeamDao;
import io.avengers.domain.Team;
import io.avengers.service.TeamService;

public class TestApplicationTeam {

	public static void main(String[] args) {

		TeamDao dao=new TeamDao();
		TeamService service = new TeamService();
		 //System.out.println(service.findAll());

		// recherche tous les films pareil au nom
		 Team t= service.findTeamById(2);
	
		 System.out.println(t.getName());
		 
		 
		
		
		 
		 Set<Team> teams= service.findTeamsByName("Av");
		 System.out.println(teams);
		
		 Team te= service.findTeamByName("Avengers");
		 System.out.println(te);
		 
	}

}
