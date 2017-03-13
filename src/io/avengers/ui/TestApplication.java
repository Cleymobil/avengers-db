package io.avengers.ui;

import java.security.Provider.Service;
import java.sql.SQLException;

import io.avengers.dao.HeroDao;
import io.avengers.domain.Hero;
import io.avengers.service.HeroService;

public class TestApplication {

	public static void main(String[] args) throws Exception {
		HeroService service = new HeroService();
		// System.out.println(service.findAll());
	
		System.out.println(service.findHeroesByName("man"));
		//System.out.println(service.findHeroesById(5));
	}

}
