package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import io.avengers.dao.TeamDao;
import io.avengers.domain.Hero;
import io.avengers.domain.Team;

import java.sql.Connection;
import java.sql.SQLException;


public class HeroServiceTest {
	

	HeroService heroService;

	Hero test = new Hero("tonton2", "tuntun",2);
	
	@Before
	public void setUp() throws Exception {
		heroService= new HeroService();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		assertTrue(heroService.findAll().size()>1);
		assertFalse(heroService.findAll().size()<0);
	}
	
	@Test
	public void testFindHeroesByName(){
		assertTrue(heroService.findHeroesByName("Spider").size()==1);
		assertTrue((heroService.findHeroesByName("Spider").iterator().next()).getName().contains("i"));
		
	}
	@Test
	public void testFindHeroesById() throws SQLException{
		assertTrue(heroService.findHeroesById(1).getName().equals("Spiderman"));
		assertFalse(heroService.findHeroesById(1).getName().equals("Hulk"));
	}
	@Test
	public void testCreateModifyDeleteHero() throws SQLException {
	
		int heroid=heroService.createHero(test).getId();
		
		assertTrue(heroid>0);
		test=(heroService.findHeroesById(heroid));
		assertTrue(test.getId()==heroid);
		assertNotNull(test.getTeamId());
		
		heroService.removeTeamFromHero(test);
		assertNull(test.getTeamId());
		
		heroService.changeHeroName(heroid, "Manolo1");
		assertTrue(test.getName().equals("Manolo1"));
		
		heroService.changeHeroName(heroid, "tonton2");
		heroService.deleteHero(heroService.findHeroesById(heroid));
		assertTrue(heroService.findHeroesByName("tonton2").isEmpty());
		
		
		
		
	}
	
	
	
}
