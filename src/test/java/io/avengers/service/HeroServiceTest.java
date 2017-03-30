package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.avengers.domain.Hero;

import java.sql.Connection;
import java.sql.SQLException;

public class HeroServiceTest {

	HeroService heroService;

	Hero test = new Hero(0,"tonton1");
	
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
	public void testNewHero() throws SQLException {
		Hero hero=heroService.createHero(test);
		hero.setIrl("tururu");
		assertTrue(hero.getId()!=0);
		heroService.deleteHero(hero);
		
	}
}
