package io.avengers.service;

import java.sql.SQLException;

import io.avengers.dao.HeroDataDao;
import io.avengers.domain.Hero;

public class HeroDataService {

	IllegalStateException stateException = new IllegalStateException("There is an error in the database please try again later");
	
	public Hero findHeroData(String term) {
		
		try {
			return new HeroDataDao().findHeroData(term);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw stateException;
		}
	}
	

}
