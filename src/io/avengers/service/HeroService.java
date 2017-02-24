package io.avengers.service;

import java.sql.SQLException;
import java.util.Set;

import io.avengers.dao.HeroDao;
import io.avengers.domain.Hero;

public class HeroService {

	public Set<Hero> findAll() throws Exception {
		return new HeroDao().findAll();
	}
}
