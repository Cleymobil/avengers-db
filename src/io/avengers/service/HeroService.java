package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.HeroDao;
import io.avengers.domain.Hero;
import io.avengers.domain.Sex;

public class HeroService {

	IllegalStateException stateException = new IllegalStateException(
			"There is an error in the database please try again later");

	public Set<Hero> findAll() {

		try {
			return new HeroDao().findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Set<Hero> findHeroesByName(String term) {
		if (term == null) {
			System.out.println("Potential bug or illegal request");
			return this.findAll();
		}
		if (term.isEmpty()) {
			return this.findAll();
		}

		try {
			return new HeroDao().findHeroesByName(term);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public Hero findHeroesById(int id) {

		try {
			return new HeroDao().findHeroesById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

	public void createHero(Hero hero) {

		try {
			int heroId = new HeroDao().createHero(hero);
			if (hero.getTeamId() != 0) {
				new HeroDao().putHeroInTeam(hero.getTeamId(), heroId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}

}
