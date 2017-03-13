package io.avengers.ui;

import java.util.Set;

import io.avengers.domain.Team;
import io.avengers.service.TeamService;

public class TestApplicationTeam {

	public static void main(String[] args) {

		
		TeamService service = new TeamService();
		 //System.out.println(service.findAll());

		// recherche tous les films pareil au nom
		 Set<Team> team = service.findTeamById(2);
		 for (Team t : team){
		 System.out.println(t.getName());
		}
	}

}
